package Process;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcess {
    private final static Pattern PATTERN = Pattern.compile("(.*?)(?:\\((\\d+)\\))?(\\.[^.]*)?");
    private static final String ACCESS_TOKEN = "sTX84uHl2iAAAAAAAAAAErI6t5Uwpner7xbs6kSVByvUBXOHydpgFb-6nB5RNuAJ";
    private static DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
    private static DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    public static String uploadToDropBox(MultipartFile file){
        String path = "";
        String fileName = getNewNameIfDuplicateName(file.getOriginalFilename());
        try  {
            FileMetadata metadata = client.files().uploadBuilder("/"+fileName)
                    .uploadAndFinish(file.getInputStream());
            SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings("/"+fileName);
            path = sharedLinkMetadata.getUrl();
        } catch (UploadErrorException e) {
            e.printStackTrace();
        } catch (DbxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = (path.split("/?dl"))[0];
        path = path+"raw=1";
        return path;
    }
    private static boolean checkFileNameDuplicateOnDropBox(String filename){
        try {
            SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings("/"+filename);
        } catch (DbxException e) {
            if(e.getMessage().contains("shared_link_already_exists")){
                return true;
            }
        }
        return false;
    }

    private static String getNewNameIfDuplicateName(String filename) {
        Matcher m = PATTERN.matcher(filename);
        if (m.matches()) {
            String prefix = m.group(1);
            String last = m.group(2);
            String suffix = m.group(3);
            if (suffix == null) suffix = "";
            int count = last != null ? Integer.parseInt(last) : 0;
            while (checkFileNameDuplicateOnDropBox(filename)) {
                count++;
                filename = prefix + "(" + count + ")" + suffix;
            }
        }
        return filename;
    }
}
