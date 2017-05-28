package mad.rpg.utils;

import mad.rpg.game.Messages;

public class FileDeserializationException extends Exception {

    public FileDeserializationException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return Messages.FILE_DESERIALIZATION_EXCEPTION_MESSAGE;
    }

}
