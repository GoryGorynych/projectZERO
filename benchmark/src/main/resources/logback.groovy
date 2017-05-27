def LOG_PATH = "logs"

appender("Console-Appender", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%msg%n"
    }
}

root(INFO, ["File-Appender"])