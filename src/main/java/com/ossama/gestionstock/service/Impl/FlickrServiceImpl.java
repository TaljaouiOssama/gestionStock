package com.ossama.gestionstock.service.Impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.ossama.gestionstock.service.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service
@Slf4j
public class FlickrServiceImpl implements FlickrService {
    private Flickr flickr;
    @Autowired
    public FlickrServiceImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override
    public String savePicture(InputStream picture, String title) throws FlickrException {
        UploadMetaData uploadMetaData=new UploadMetaData();
        uploadMetaData.setTitle(title);
        String pictureId=flickr.getUploader().upload(picture,uploadMetaData);

        return flickr.getPhotosInterface().getPhoto(pictureId).getMedium640Url();
    }
}
