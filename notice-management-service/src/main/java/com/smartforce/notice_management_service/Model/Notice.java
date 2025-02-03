package com.smartforce.notice_management_service.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "notices")
public class Notice {

    @Id
    private String id;
    private String noticeId;
    private String title;
    private String fileName;
    private LocalDate publishedDate;

    public Notice() {
    }

    public Notice(String id, String noticeId, String title, String fileName, LocalDate publishedDate) {
        this.id = id;
        this.noticeId = noticeId;
        this.title = title;
        this.fileName = fileName;
        this.publishedDate = publishedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
