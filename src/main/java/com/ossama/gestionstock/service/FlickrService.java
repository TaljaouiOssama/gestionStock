package com.ossama.gestionstock.service;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrService {
    String savePicture(InputStream inputStream,String title) throws FlickrException;
}
