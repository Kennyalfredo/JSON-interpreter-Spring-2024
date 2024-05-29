class FileManager {
    private JSONFile uploadedFile;

    public boolean uploadFile(JSONFile file) {
        if (file != null && file.isValid()) {
            uploadedFile = file;
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        uploadedFile = null;
    }

    public JSONFile getUploadedFile() {
        return uploadedFile;
    }
}