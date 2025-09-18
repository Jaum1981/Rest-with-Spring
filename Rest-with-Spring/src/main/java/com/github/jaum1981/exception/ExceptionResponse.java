package com.github.jaum1981.exception;

import java.util.Date;

public record ExceptionResponse(Date timeStamp, String message, String details) {}