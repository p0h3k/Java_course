package ru.sgu;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.*;

public class DirectoryArchiver {

    private Path directoryPath;
    private String targetString;
    private ZipOutputStream zos;
    private boolean inTargetDirectory = false;

    public DirectoryArchiver(String directoryPath, String targetString) {
        this.directoryPath = Paths.get(directoryPath);
        this.targetString = targetString.toLowerCase();
    }

    public void archive(String archiveName) {
        try {
            zos = new ZipOutputStream(new FileOutputStream(archiveName));
            Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (dir.getFileName().toString().toLowerCase().contains(targetString) || dir.equals(directoryPath)) {
                        inTargetDirectory = true;
                        addDirectoryToZip(dir);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (inTargetDirectory || file.getFileName().toString().toLowerCase().contains(targetString)) {
                        addFileToZip(file);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (dir.getFileName().toString().toLowerCase().contains(targetString) || dir.equals(directoryPath)) {
                        inTargetDirectory = false;
                    }
                    return FileVisitResult.CONTINUE;
                }

                private void addFileToZip(Path file) throws IOException {
                    ZipEntry zipEntry = new ZipEntry(directoryPath.relativize(file).toString());
                    zos.putNextEntry(zipEntry);
                    Files.copy(file, zos);
                    zos.closeEntry();
                }

                private void addDirectoryToZip(Path dir) throws IOException {
                    ZipEntry zipEntry = new ZipEntry(directoryPath.relativize(dir).toString() + "/");
                    zos.putNextEntry(zipEntry);
                    zos.closeEntry();
                }
            });
            zos.close();
            System.out.println("Архивация завершена. Создан архив: " + archiveName);
        } catch (IOException e) {
            System.err.println("Ошибка при архивации: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Используйте: DirectoryArchiver <путь до директории> <целевая строка>");
            return;
        }

        DirectoryArchiver archiver = new DirectoryArchiver(args[0], args[1]);
        archiver.archive(args[0] + ".zip");
    }
}
