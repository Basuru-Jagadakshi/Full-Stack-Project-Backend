package com.smartforce.notice_management_service.Service;

import com.smartforce.notice_management_service.Model.Notice;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NoticeService {

    Notice createNotice(String noticeId, String title, String fileName);

    List<Notice> getAllNotices();

    Optional<Notice> getNoticeById(String id);

    Notice updateNotice(String id, String noticeId, String title, String fileName);

    void deleteNotice(String id);
}
