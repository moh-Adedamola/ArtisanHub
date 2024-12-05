package com.semicolon.artisanhub.services;

public interface NotificationService {
    void sendNotification(String to, String subject, String message);
}
