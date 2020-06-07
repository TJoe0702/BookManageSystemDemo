package com.example.BootVue.repository;

import com.example.BootVue.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @Author tujun
 * @date 2020/6/4 -11:43
 */
@Component
public interface BookRepository extends JpaRepository<Book,Integer> {
}
