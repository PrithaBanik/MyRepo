package com.cerner.patientPortalBackend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author PB077048
 *A new collection is created to store the sequence number in the database.
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

    public DatabaseSequence() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
