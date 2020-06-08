package com.example.demo;

public class UploadFileResponse {
    private String fileName;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String fileType, long size) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
    }

    // Getters and Setters (Omitted for brevity)
}
