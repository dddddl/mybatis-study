package com.tjise.mapper;

import com.tjise.entity.Blob;

import java.util.List;
import java.util.Map;

public interface BlobMapper {


    List<Blob> queryBlogIF(Map<String,String> map);
    List<Blob> queryBlogChoose(Map<String,String> map);
}
