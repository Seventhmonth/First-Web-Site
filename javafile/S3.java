package market;

import java.io.InputStream;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.*;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3 {
	public static void DoUpload(String Name, InputStream Stream) {
        AmazonS3 s3 = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider());
		Region myRegion = Region.getRegion(Regions.US_EAST_1);
		s3.setRegion(myRegion);

        String bucketName = "qijunliu1113";

        PutObjectRequest request = new PutObjectRequest(bucketName, Name, Stream, null);
        request.setCannedAcl(CannedAccessControlList.PublicRead);
        s3.putObject(request);
	}
}
