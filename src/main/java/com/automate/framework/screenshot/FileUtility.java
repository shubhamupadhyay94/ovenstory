package com.automate.framework.screenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtility {
	static Logger logger = Logger.getLogger(FileUtility.class);

	public static String createDirectory(String name) throws Exception {
		boolean success = false;
		String directoryLocation = "";
		File directory = new File(name);
		if (directory.exists()) {
			//logger.info("Directory already exists ..." + name);
		//	logger.info("get path " + directory.getPath());
			directoryLocation = directory.getPath();
		} else {
			logger.info("Directory not exists, creating now");

			success = directory.mkdirs();
			//logger.info("get path " + directory.getPath());

			if (success) {
				directoryLocation = directory.getPath();

				logger.info("Successfully created new directory : Directory name is  " + name);
			} else {
				logger.error("Failed to create new directory:" + name);
			}
		}
		return directoryLocation;
	}

	public static File createFile(String fileName, String filePath) throws IOException {
		boolean success = false;
		File file = new File(filePath + fileName);
		if (file.exists()) {
		//	logger.info("File already exists");

		} else {
		//	logger.info("No such file exists, creating now");
			success = file.createNewFile();
			if (success) {
				logger.info("Successfully created new file: " + file);
			} else {
				logger.error("Failed to create new file:" + file);
			}
		}
		return file;
	}

	public static void deleteDirectory(String directoryName) throws IOException {
		logger.info("Started deleting " + directoryName + "and files..");
		Path directory = Paths.get(directoryName);
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
				Files.delete(file); // this will work because it's always a File
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				Files.delete(dir); // this will work because Files in the
									// directory are already deleted
				return FileVisitResult.CONTINUE;
			}
		});
		logger.info("Unwanted files are deleted from project sucessfully. ");
	}

}
