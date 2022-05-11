package com.example.task17_criteria_api.service;

import com.example.task17_criteria_api.model.entity.IEntity;
import com.example.task17_criteria_api.model.entity.Student;
import com.example.task17_criteria_api.model.entity.University;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class BackupService {
	private final String BACKUP_DIR = "backups/";
	private final StudentService studentService;
	private final UniversityService universityService;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu H-m");

	@Autowired
	public BackupService(StudentService studentService, UniversityService universityService) {
		this.studentService = studentService;
		this.universityService = universityService;
	}

	@Scheduled(fixedRate = 60000L)
	public void backupFromDatabase() throws IOException {
		deleteOldDirectories();

		String dirName = LocalDateTime.now().format(formatter);
		String dirPath =  BACKUP_DIR + dirName;
		new File(dirPath).mkdirs();

		File universitiesFile = new File(dirPath + "/universities.data");
		File studentsFile = new File(dirPath + "/students.data");

		List<University> universities = universityService.getAll();
		List<Student> students = studentService.getAll();

		writeToFiles(universities, universitiesFile);
		writeToFiles(students, studentsFile);

		log.info("Data saved");
	}

	private void writeToFiles(List<? extends IEntity> objects, File file) throws IOException {
		PrintWriter printWriter = new PrintWriter(new FileWriter(file));
		for (IEntity entity : objects) {
			printWriter.println(entity.toString());
			printWriter.println();
		}
		printWriter.close();
	}

	private void deleteOldDirectories() {
		File file = new File(BACKUP_DIR);
		File[] files = file.listFiles();
		long curTime = System.currentTimeMillis();
		if (files != null) {
			for (File f : files) {
				if (curTime - f.lastModified() > 600_000) {
					boolean deleted = FileSystemUtils.deleteRecursively(f);
					if (deleted) {
						log.info(f.getName() + " is deleted");
					} else {
						log.info(f.getName() + " is not deleted");
					}
				}
			}
		} else {
			log.error("No saved data to delete");
			return;
		}
		log.info("Old data deleted");
	}
}
