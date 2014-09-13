package edu.agh.fis.client.file;

/**
 * Created by wemstar on 13.09.14.
 */
public class ClientFileTransport {
    public String name;
    public long clientNo;

    public ClientFileTransport(edu.agh.fis.entity.client.file.ClientFile clientFile) {


        this.clientNo=clientFile.clientNo;
        this.name=clientFile.name;

    }



}
