package org.junit.rules;

import java.io.File;
import java.io.IOException;

public class TemporaryFolder extends ExternalResource {
    private File folder;
    private final File parentFolder;

    public TemporaryFolder() {
        this((File) null);
    }

    public TemporaryFolder(File file) {
        this.parentFolder = file;
    }

    private File createTemporaryFolderIn(File file) {
        File createTempFile = File.createTempFile("junit", "", file);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    private boolean isLastElementInArray(int i, String[] strArr) {
        return i == strArr.length - 1;
    }

    private void recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File recursiveDelete : listFiles) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }

    private void validateFolderName(String str) {
        if (new File(str).getParent() != null) {
            throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
        }
    }

    /* access modifiers changed from: protected */
    public void after() {
        delete();
    }

    /* access modifiers changed from: protected */
    public void before() {
        create();
    }

    public void create() {
        this.folder = createTemporaryFolderIn(this.parentFolder);
    }

    public void delete() {
        File file = this.folder;
        if (file != null) {
            recursiveDelete(file);
        }
    }

    public File getRoot() {
        File file = this.folder;
        if (file != null) {
            return file;
        }
        throw new IllegalStateException("the temporary folder has not yet been created");
    }

    public File newFile() {
        return File.createTempFile("junit", (String) null, getRoot());
    }

    public File newFile(String str) {
        File file = new File(getRoot(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new IOException("a file with the name '" + str + "' already exists in the test folder");
    }

    public File newFolder() {
        return createTemporaryFolderIn(getRoot());
    }

    public File newFolder(String str) {
        return newFolder(str);
    }

    public File newFolder(String... strArr) {
        File root = getRoot();
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            validateFolderName(str);
            File file = new File(root, str);
            if (file.mkdir() || !isLastElementInArray(i, strArr)) {
                i++;
                root = file;
            } else {
                throw new IOException("a folder with the name '" + str + "' already exists");
            }
        }
        return root;
    }
}
