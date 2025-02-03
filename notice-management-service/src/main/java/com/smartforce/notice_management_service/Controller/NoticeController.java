package com.smartforce.notice_management_service.Controller;

import com.smartforce.notice_management_service.Model.Notice;
import com.smartforce.notice_management_service.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping
    public ResponseEntity<Notice> createNotice(@RequestParam String noticeId, @RequestParam String title, @RequestParam String fileName){
        return new ResponseEntity<>(noticeService.createNotice(noticeId,title,fileName), HttpStatus.OK);
    }

    @GetMapping
    public List<Notice> getAllNotices(){
        return noticeService.getAllNotices();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Notice> updateNotice(
            @PathVariable("id") String id,
            @RequestParam String noticeId,
            @RequestParam String title,
            @RequestParam String fileName){
        return new ResponseEntity<>(noticeService.updateNotice(id, noticeId, title, fileName), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotice(@PathVariable("id") String id) {
        noticeService.deleteNotice(id);
        return new ResponseEntity<>("Notice deleted successfully", HttpStatus.OK);
    }

}
