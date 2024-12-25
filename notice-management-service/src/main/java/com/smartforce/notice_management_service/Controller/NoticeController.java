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
    public ResponseEntity<String> createNotice(@RequestParam("title") String title, @RequestParam("file") MultipartFile file) throws IOException{
        try {
            Notice notice = noticeService.createNotice(title, file);
            return ResponseEntity.ok("Notice created successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(500).body("Error uploading notice");
        }
    }

    @GetMapping
    public List<Notice> getAllNotices(){
        return noticeService.getAllNotices();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id) {
        Optional<Notice> notice = noticeService.getNoticeById(id);
        if (notice.isPresent()) {
            Notice foundNotice = notice.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(foundNotice.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + foundNotice.getFileName() + "\"")
                    .body(foundNotice.getFileData());
        }
        return ResponseEntity.status(404).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> updateNotice(
            @PathVariable("id") String id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return new ResponseEntity<>(noticeService.updateNotice(id, title, file), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotice(@PathVariable("id") String id) {
        noticeService.deleteNotice(id);
        return new ResponseEntity<>("Notice deleted successfully", HttpStatus.OK);
    }

}
