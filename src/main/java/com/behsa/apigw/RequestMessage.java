package com.behsa.apigw;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tbl_request_test")
//@NamedQuery(name="request.findAll", query="SELECT c FROM request c")
public class RequestMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_request_test")
    @SequenceGenerator(name = "seq_request_test", sequenceName = "SEQ_REQUEST_TEST")
    @Column(name = "PK_REQUEST_TEST")
    Long Id;
    @Column(name = "source_address")
    @NotEmpty(message = "not be empty")

    String sourceAddress;
    @Column(name = "destination_address")
    @NotEmpty(message = "not be empty")

    String destinationAddress;
    @Column(name = "http_head")
    @NotEmpty(message = "not be empty")

    String httpHead;
    @Column(name = "http_body")
    @NotEmpty(message = "not be empty")

    String httpBody;

    public RequestMessage() {
    }

    public RequestMessage(String sourceAddress, String destinationAddress, String httpHead, String httpBody) {
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.httpHead = httpHead;
        this.httpBody = httpBody;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getHttpHead() {
        return httpHead;
    }

    public void setHttpHead(String httpHead) {
        this.httpHead = httpHead;
    }

    public String getHttpBody() {
        return httpBody;
    }

    public void setHttpBody(String httpBody) {
        this.httpBody = httpBody;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "RequestMessage{" +
                "Id=" + Id +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", destination_address='" + destinationAddress + '\'' +
                ", http_head='" + httpHead + '\'' +
                ", http_body='" + httpBody + '\'' +
                '}';
    }
}
