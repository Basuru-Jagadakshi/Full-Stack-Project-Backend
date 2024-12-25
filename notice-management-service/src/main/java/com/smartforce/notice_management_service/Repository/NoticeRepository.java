package com.smartforce.notice_management_service.Repository;

import com.smartforce.notice_management_service.Model.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticeRepository extends MongoRepository<Notice, String> {

}
