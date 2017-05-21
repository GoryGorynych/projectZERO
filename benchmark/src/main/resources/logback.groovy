def LOG_PATH = "logs"

appender("Console-Appender", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%msg%n"
    }
}
appender("File-Appender", FileAppender) {
    file = "${LOG_PATH}/logfile.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%msg%n"
        outputPatternAsHeader = true
    }
}

root(INFO, ["File-Appender"])