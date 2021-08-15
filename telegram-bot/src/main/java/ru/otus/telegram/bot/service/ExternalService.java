package ru.otus.telegram.bot.service;

public interface ExternalService {
    String getAllDBServiceInfo();
    String getDBServerByServerName(String name);
    String checkAll();
    String checkByDBServerName(String name);
}
