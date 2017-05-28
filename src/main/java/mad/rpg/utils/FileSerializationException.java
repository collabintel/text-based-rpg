package mad.rpg.utils;

import mad.rpg.game.Messages;

public class FileSerializationException extends Exception {

    public FileSerializationException(Throwable cause){
        super(cause);
    }

    @Override
    public String getMessage() {
        return Messages.FILE_SERIALIZATION_EXCEPTION_MESSAGE;
    }

}
