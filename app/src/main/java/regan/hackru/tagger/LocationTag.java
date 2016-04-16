package regan.hackru.tagger;

import android.location.Location;
import android.nfc.Tag;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAutoGeneratedKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshalling;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Regan on 4/16/2016.
 */
@DynamoDBTable(tableName = "LocationTag")
public class LocationTag {
    private String tagID;
    private String author;
    private Location loc;


    @DynamoDBHashKey(attributeName = "Tag ID")
    @DynamoDBAutoGeneratedKey
    public String getTagID() {
        return tagID;
    }

    public void setTagID(String tagID) {
        this.tagID = tagID;
    }

    @DynamoDBIndexRangeKey(attributeName = "Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @DynamoDBIndexHashKey(attributeName = "Location")
    @DynamoDBMarshalling(marshallerClass = LocationMarshaller.class)
    public Location getLocation() {
        return loc;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
    }


}
