package com.smartforce.notice_management_service.Service.Impl;

import com.smartforce.notice_management_service.Model.Notice;
import com.smartforce.notice_management_service.Repository.NoticeRepository;
import com.smartforce.notice_management_service.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public Notice createNotice(String title, MultipartFile file) throws IOException {
        Notice notice = new Notice();

        notice.setTitle(title);
        notice.setFileName(file.getOriginalFilename());
        notice.setContentType(file.getContentType());
        notice.setFileData(file.getBytes());
        notice.setPublishedDate(LocalDate.now());

        return noticeRepository.save(notice);
    }

    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Override
    public Optional<Notice> getNoticeById(String id) {
        return noticeRepository.findById(id);
    }

    @Override
    public Notice updateNotice(String id, String title, MultipartFile file) throws IOException {
        Notice existingNotice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("Notice not found with id: " + id));

        if (title != null && !title.isEmpty()) {
            existingNotice.setTitle(title);
        }

        if (file != null) {
            existingNotice.setFileName(file.getOriginalFilename());
            existingNotice.setContentType(file.getContentType());
            existingNotice.setFileData(file.getBytes());
        }

        return noticeRepository.save(existingNotice);
    }


    @Override
    public void deleteNotice(String id) {
        noticeRepository.findById(id).orElseThrow(() -> new RuntimeException());
        noticeRepository.deleteById(id);
    }
}