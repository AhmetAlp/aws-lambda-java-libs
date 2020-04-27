package com.amazonaws.lambda.runtime.events;

import org.joda.time.DateTime;

import com.amazonaws.internal.DateTimeJsonSerializer;
import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.List;

/**
 * Represents Amazon SES event.
 * @author Ahmet Alp
 */
public class SESEvent implements Serializable, Cloneable {

	private static final long serialVersionUID = 8086472811955015521L;
    
	private List<SESRecord> records;
	
    /**
     * default constructor
     */
	public SESEvent() {}
	
    @JsonCreator
    public SESEvent(@JsonProperty(value = "Records") List<SESRecord> records) {
        this.records = records;
    }
    
    public static SESEvent parseJson(String json) {
        return Jackson.fromJsonString(json, SESEvent.class);
    }
	
    /**
     *  Gets the list of SES records
     * @return List of records
     */
    @JsonProperty(value = "Records")
	public List<SESRecord> getRecords() {
        return records;
    }

    /**
     * Sets a list of SES records
     * @param records A list of SES record objects
     */
    public void setRecords(@JsonProperty(value = "Records") List<SESRecord> records) {
        this.records = records;
    }

    /**
     * @param records a List of SESRecords
     * @return SESEvent
     */
    public SESEvent withRecords(@JsonProperty(value = "Records") List<SESRecord> records) {
        setRecords(records);
        return this;
    }

    /**
     * @return a JSON representation of this object
     */
    public String toJson() {
        return Jackson.toJsonString(this);
    }
    
    /**
     * Returns a string representation of this object; useful for testing and debugging.
     * @return A string representation of this object.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRecords() != null) {
            sb.append(getRecords());
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof SESEvent)) {
            return false;
        } else {
	        SESEvent other = (SESEvent) obj;
	        if ((other.getRecords() == null ^ this.getRecords() == null) 
	        		|| (other.getRecords() != null && !other.getRecords().equals(this.getRecords()))) {
	            return false;
	        }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getRecords() == null) ? 0 : getRecords().hashCode());
        return hashCode;
    }

    @Override
    public SESEvent clone() {
        try {
            return (SESEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
        }
    }
    
    /**
     * Represents an SES message record. SES message records are used to send
     * SES messages to Lambda Functions.
     *
     */
    public static class SESRecord implements Serializable, Cloneable {
    	
        private static final long serialVersionUID = -309065548155161859L;

        private SES ses;
        private String eventVersion;
        private String eventSource;
        
        /**
         * default constructor
         * (Not available in v1)
         */
        public SESRecord() {}

        /**
         * Gets the SES message
         * @return ses body of message
         */
        public SES getSES() {
            return ses;
        }

        /**
         * Sets the SES message
         * @param ses An SES object representing the SES message
         */
        public void setSes(SES ses) {
            this.ses = ses;
        }

        /**
         * @param ses SES message object
         * @return SESRecord
         */
        public SESRecord withSes(SES ses) {
            setSes(ses);
            return this;
        }

        /**
         * Gets the event version
         * @return event version
         */
        public String getEventVersion() {
            return eventVersion;
        }

        /**
         * Sets the event version
         * @param eventVersion A string containing the event version
         */
        public void setEventVersion(String eventVersion) {
            this.eventVersion = eventVersion;
        }

        /**
         * @param eventVersion event version
         * @return SESRecord
         */
        public SESRecord withEventVersion(String eventVersion) {
            setEventVersion(eventVersion);
            return this;
        }

        /**
         * Gets the event source
         * @return event source
         */
        public String getEventSource() {
            return eventSource;
        }

        /**
         * Sets the event source
         * @param eventSource A string containing the event source
         */
        public void setEventSource(String eventSource) {
            this.eventSource = eventSource;
        }

        /**
         * @param eventSource event source
         * @return SESRecord
         */
        public SESRecord withEventSource(String eventSource) {
            setEventSource(eventSource);
            return this;
        }

        /**
         * Returns a string representation of this object; useful for testing and debugging.
         * @return A string representation of this object.
         * @see Object#toString()
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            if (getSES() != null) {
                sb.append("ses: ").append(getSES().toString()).append(",");
            }
            if (getEventVersion() != null) {
                sb.append("eventVersion: ").append(getEventVersion()).append(",");
            }
            if (getEventSource() != null) {
                sb.append("eventSource: ").append(getEventSource()).append(",");
            }
            sb.append("}");
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (obj == null) {
                return false;
            }

            if (!(obj instanceof SESRecord)) {
                return false;
            }
            SESRecord other = (SESRecord) obj;
            return !((other.getSES() == null ^ this.getSES() == null)
                || (other.getSES() != null && !other.getSES().equals(this.getSES()))
                || (other.getEventVersion() == null ^ this.getEventVersion() == null)
                || (other.getEventVersion() != null && !other.getEventVersion().equals(this.getEventVersion()))
                || (other.getEventSource() == null ^ this.getEventSource() == null)
                || (other.getEventSource() != null && !other.getEventSource().equals(this.getEventSource())));
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int hashCode = 1;

            hashCode = prime * hashCode + ((getSES() == null) ? 0 : getSES().hashCode());
            hashCode = prime * hashCode + ((getEventVersion() == null) ? 0 : getEventVersion().hashCode());
            hashCode = prime * hashCode + ((getEventSource() == null) ? 0 : getEventSource().hashCode());
            return hashCode;
        }

        @Override
        public SESRecord clone() {
            try {
                return (SESRecord) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
        
    }

    /**
     * Represents an SES message
     */
    public static class SES implements Serializable, Cloneable {    
		private static final long serialVersionUID = 6796039631151085451L;

		/**
	     * Common headers in an SES message
	     */
	    public static class CommonHeaders implements Serializable, Cloneable{
	        static final String OBJECT_CLONE_EX = "Got a CloneNotSupportedException from Object.clone() ";
			/**
			 * 
			 */
			private static final long serialVersionUID = -2970350479100195821L;
			private List<String> from;
	        private List<String> cc;
	        private List<String> bcc;
	        private List<String> to;
	        private String returnPath;
	        private String messageId;
	        private String date;
	        private String subject;
	
	        /**
	         * get list of address from (list of 1)
	         * @return List of email addresses
	         */
	        public List<String> getFrom() {
	            return this.from;
	        }
	
	        /**
	         * Set the from address
	         * @param from List of email addresses
	         */
	        public void setFrom (List<String> from){
	            this.from = from;
	        }
	
	        /**
	         * @param from email addresses
	         * @return CommonHeaders
	         */
	        public CommonHeaders withFrom(List<String> from) {
	            setFrom(from);
	            return this;
	        }
	
	        /**
	         * get list of addresses cc
	         * @return List of email addresses
	         */
	        public List<String> getCc() {
	            return this.cc;
	        }
	
	        /**
	         * Set the cc address
	         * @param cc List of email addresses
	         */
	        public void setCc (List<String> cc){
	            this.cc = cc;
	        }
	
	        /**
	         * @param cc email addresses
	         * @return CommonHeaders
	         */
	        public CommonHeaders withCc(List<String> cc) {
	            setCc(cc);
	            return this;
	        }
	
	        /**
	         * get list of addresses bcc
	         * @return List of email addresses
	         */
	        public List<String> getBcc() {
	            return this.bcc;
	        }
	
	        /**
	         * Set the bcc address
	         * @param bcc List of email addresses
	         */
	        public void setBcc (List<String> bcc){
	            this.bcc = bcc;
	        }
	
	        /**
	         * @param bcc email addresses
	         * @return CommonHeaders
	         */
	        public CommonHeaders withBcc(List<String> bcc) {
	            setBcc(bcc);
	            return this;
	        }
	
	        /**
	         * get list of addresses to
	         * @return List of email addresses
	         */
	        public List<String> getTo() {
	            return this.to;
	        }
	
	        /**
	         * Set the cc address
	         * @param to List of email addresses
	         */
	        public void setTo (List<String> to){
	            this.to = to;
	        }
	
	        /**
	         * @param to email addresses
	         * @return CommmonHeaders
	         */
	        public CommonHeaders withTo(List<String> to) {
	            setTo(to);
	            return this;
	        }
	
	        /**
	         * get the returnPath
	         * @return the return path
	         */
	        public String getReturnPath() {
	            return this.returnPath;
	        }
	
	        /**
	         * Set the returnPath
	         * @param returnPath String with return path
	         */
	        public void setReturnPath (String returnPath){
	            this.returnPath = returnPath;
	        }
	
	        /**
	         * @param returnPath String with return path
	         * @return CommonHeaders
	         */
	        public CommonHeaders withReturnPath(String returnPath) {
	            setReturnPath(returnPath);
	            return this;
	        }
	
	        /**
	         * get the message id
	         * @return the message id
	         */
	        public String getMessageId() {
	            return this.messageId;
	        }
	
	        /**
	         * Set the message id
	         * @param messageId String with message id
	         */
	        public void setMessageId (String messageId){
	            this.messageId = messageId;
	        }
	
	        /**
	         * @param messageId String with message id
	         * @return CommonHeaders
	         */
	        public CommonHeaders withMessageId(String messageId) {
	            setMessageId(messageId);
	            return this;
	        }
	
	        /**
	         * get the date
	         * @return the date
	         */
	        public String getDate() {
	            return this.date;
	        }
	
	        /**
	         * Set the date
	         * @param date the date message was sent
	         */
	        public void setDate(String date){
	            this.date = date;
	        }
	
	        public CommonHeaders withDate(String date) {
	            setDate(date);
	            return this;
	        }
	
	        /**
	         * get the subject
	         * @return the subject
	         */
	        public String getSubject() {
	            return this.subject;
	        }
	
	        /**
	         * Set the subject
	         * @param subject of meail
	         */
	        public void setSubject (String subject){
	            this.subject = subject;
	        }
	
	        public CommonHeaders withSubject(String subject) {
	            setSubject(subject);
	            return this;
	        }
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         *
	         * @return A string representation of this object.
	         *
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getFrom() != null)
	                sb.append("from: ").append(getFrom().toString()).append(",");
	            if (getTo() != null)
	                sb.append("to: ").append(getTo().toString()).append(",");
	            if (getBcc() != null)
	                sb.append("bcc: ").append(getBcc().toString()).append(",");
	            if (getCc() != null)
	                sb.append("cc: ").append(getCc().toString()).append(",");
	            if (getMessageId() != null)
	                sb.append("messageId: ").append(getMessageId()).append(",");
	            if (getReturnPath() != null)
	                sb.append("returnPath: ").append(getReturnPath()).append(",");
	            if (getDate() != null)
	                sb.append("date: ").append(getDate()).append(",");
	            if (getSubject() != null)
	                sb.append("subject: ").append(getSubject());
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (obj == null) {
	                return false;
	            }
	
	            if (!(obj instanceof CommonHeaders)) {
	                return false;
	            }
	            CommonHeaders other = (CommonHeaders) obj;
	            return !((other.getFrom() == null ^ this.getFrom() == null)
	                || (other.getFrom() != null && !other.getFrom().equals(this.getFrom()))
	                || (other.getTo() == null ^ this.getTo() == null)
	                || (other.getTo() != null && !other.getTo().equals(this.getTo()))
	                || (other.getBcc() == null ^ this.getBcc() == null)
	                || (other.getBcc() != null && !other.getBcc().equals(this.getBcc()))
	                || (other.getCc() == null ^ this.getCc() == null)
	                || (other.getCc() != null && !other.getCc().equals(this.getCc()))
	                || (other.getMessageId() == null ^ this.getMessageId() == null)
	                || (other.getMessageId() != null && !other.getMessageId().equals(this.getMessageId()))
	                || (other.getReturnPath() == null ^ this.getReturnPath() == null)
	                || (other.getReturnPath() != null && !other.getReturnPath().equals(this.getReturnPath()))
	                || (other.getDate() == null ^ this.getDate() == null)
	                || (other.getDate() != null && !other.getDate().equals(this.getDate()))
	                || (other.getSubject() == null ^ this.getSubject() == null)
	                || (other.getSubject() != null && !other.getSubject().equals(this.getSubject())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getFrom() == null) ? 0 : getFrom().hashCode());
	            hashCode = prime * hashCode + ((getTo() == null) ? 0 : getTo().hashCode());
	            hashCode = prime * hashCode + ((getBcc() == null) ? 0 : getBcc().hashCode());
	            hashCode = prime * hashCode + ((getCc() == null) ? 0 : getCc().hashCode());
	            hashCode = prime * hashCode + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
	            hashCode = prime * hashCode + ((getReturnPath() == null) ? 0 : getReturnPath().hashCode());
	            hashCode = prime * hashCode + ((getDate() == null) ? 0 : getDate().hashCode());
	            hashCode = prime * hashCode + ((getSubject() == null) ? 0 : getSubject().hashCode());
	            return hashCode;
	        }
	
	        @Override
	        public CommonHeaders clone() {
	            try {
	                return (CommonHeaders) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException(OBJECT_CLONE_EX, e);
	            }
	        }
	
	    }
	
	    /**
	     * Header entry in SES
	     */
	    public static class Header implements Serializable, Cloneable {
			private static final long serialVersionUID = 2786389341081916357L;
			private String name;
	        private String value;
	
	        /**
	         * get name of header field
	         * @return STring with header field name
	         */
	        public String getName() {
	            return this.name;
	        }
	
	        /**
	         * set header filed name
	         * @param name String name
	         */
	        public void setName(String name) {
	            this.name = name;
	        }
	
	        /**
	         * @param name header name
	         * @return Header
	         */
	        public Header withName(String name) {
	            setName(name);
	            return this;
	        }
	
	        /**
	         * get Header field value
	         * @return String header value
	         */
	        public String getValue() {
	            return this.value;
	        }
	
	        /** set header filed value
	         * @param value String header value
	         */
	        public void setValue(String value) {
	            this.value = value;
	        }
	
	        /**
	         * @param value header value
	         * @return Header
	         */
	        public Header withValue(String value) {
	            setValue(value);
	            return this;
	        }
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         *
	         * @return A string representation of this object.
	         *
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getName() != null)
	                sb.append("name: ").append(getName()).append(",");
	            if (getValue() != null)
	                sb.append("value: ").append(getValue());
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (obj == null) {
	                return false;
	            }
	
	            if (!(obj instanceof Header)) {
	                return false;
	            }
	            Header other = (Header) obj;
	            
	            return !((other.getName() == null ^ this.getName() == null)
	                || (other.getName() != null && !other.getName().equals(this.getName()))
	                || (other.getValue() == null ^ this.getValue() == null)
	                || (other.getValue() != null && !other.getValue().equals(this.getValue())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode());
	            hashCode = prime * hashCode + ((getValue() == null) ? 0 : getValue().hashCode());
	
	            return hashCode;
	        }
	
	        @Override
	        public Header clone() {
	            try {
	                return (Header) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() ", e);
	            }
	        }
	    }
	
	    /**
	     * represents an SES mail object
	     */
	    public static class Mail implements Serializable, Cloneable {
			private static final long serialVersionUID = 7328275928756255644L;
			private DateTime timestamp;
	        private String messageId;
	        private String source;
	        private String sourceArn;
	        private String sourceIp;
	        private String sendingAccountId;
	        private List<String> destination;
	        private Boolean headersTruncated;
	        private List<Header> headers;
	        private CommonHeaders commonHeaders;
	        
	        @JsonCreator
	        public Mail(
	                @JsonProperty(value = "timestamp") String timestamp,
	                @JsonProperty(value = "messageId") String messageId,
	                @JsonProperty(value = "source") String source,
	                @JsonProperty(value = "sourceArn") String sourceArn,
	                @JsonProperty(value = "sourceIp") String sourceIp,
	                @JsonProperty(value = "sendingAccountId") String sendingAccountId,
	                @JsonProperty(value = "destination") List<String> destination,
	                @JsonProperty(value = "headersTruncated") Boolean headersTruncated,
	                @JsonProperty(value = "headers") List<Header> headers,
	                @JsonProperty(value = "commonHeaders") CommonHeaders commonHeaders)
	        {
	            this.messageId = messageId;
	            this.source = source;
	            this.sourceArn = sourceArn;

	            if (timestamp != null)
	            {
	                this.timestamp = DateTime.parse(timestamp);
	            }

	            this.sourceIp = sourceIp;
	            this.sendingAccountId = sendingAccountId;
	            this.destination = destination;
	            this.headersTruncated = headersTruncated;
	            this.headers = headers;
	            this.commonHeaders = commonHeaders;
	        }
	
	        /**
	         * get timestamp
	         * @return timestamp that message was sent
	         */
	        @JsonSerialize(using=DateTimeJsonSerializer.class)
	        public DateTime getTimestamp() {
	            return this.timestamp;
	        }
	
	        /**
	         * set timestamp of message
	         * @param timestamp DateTime of message
	         */
	        public void setTimestamp(DateTime timestamp) {
	            this.timestamp = timestamp;
	        }
	
	        /**
	         * @param timestamp Date
	         * @return Mail
	         */
	        public Mail withTimestamp(DateTime timestamp) {
	            setTimestamp(timestamp);
	            return this;
	        }
	
	        /**
	         * get message id
	         * @return String message id
	         */
	        public String getMessageId() {
	            return this.messageId;
	        }
	
	        /**
	         * set message id
	         * @param messageId String with message id
	         */
	        public void setMessageId(String messageId) {
	            this.messageId = messageId;
	        }
	
	        /**
	         * @param messageId message id
	         * @return Mail
	         */
	        public Mail withMessageId(String messageId) {
	            setMessageId(messageId);
	            return this;
	        }
	
	        /**
	         * source of email
	         * @return source of email
	         */
	        public String getSource() {
	            return this.source;
	        }
	
	        /**
	         * set source of email
	         * @param source String email source
	         */
	        public void setSource(String source) {
	            this.source = source;
	        }
	
	        /**
	         * @param source source of email
	         * @return Mail
	         */
	        public Mail withSource(String source) {
	            setSource(source);
	            return this;
	        }
	
	        /**
	         * get arn of source
	         * @return String arn of source
	         */
	        public String getSourceArn() {
	            return this.sourceArn;
	        }
	
	        /**
	         * set source arn
	         * @param sourceArn String with arn of source
	         */
	        public void setSourceArn(String sourceArn) {
	            this.sourceArn = sourceArn;
	        }
	
	        /**
	         * @param sourceArn source arn
	         * @return Mail
	         */
	        public Mail withSourceArn(String sourceArn) {
	            setSourceArn(sourceArn);
	            return this;
	        }
	
	        /**
	         * get source ip address
	         * @return String source ip address
	         */
	        public String getSourceIp() {
	            return this.sourceIp;
	        }
	
	        /**
	         * set source ip
	         * @param sourceIp String ip adress
	         */
	        public void setSourceIp(String sourceIp) {
	            this.sourceIp = sourceIp;
	        }
	
	        /**
	         * @param sourceIp source ip address
	         * @return Mail
	         */
	        public Mail withSourceIp(String sourceIp) {
	            setSourceIp(sourceIp);
	            return this;
	        }
	
	        /**
	         * get sending account id
	         * @return String with account id
	         */
	        public String getSendingAccountId() {
	            return this.sendingAccountId;
	        }
	
	        /**
	         * set sending account id
	         * @param sendingAccountId String with account id
	         */
	        public void setSendingAccountId(String sendingAccountId) {
	            this.sendingAccountId = sendingAccountId;
	        }
	
	        /**
	         * @param sendingAccountId sending account id
	         * @return Mail
	         */
	        public Mail withSendingAccountId(String sendingAccountId) {
	            setSendingAccountId(sendingAccountId);
	            return this;
	        }
	
	        /**
	         * get list of destinations
	         * @return List of email addresses
	         */
	        public List<String> getDestination() {
	            return this.destination;
	        }
	
	        /**
	         * set email destination
	         * @param destination List of email addresses
	         */
	        public void setDestination(List<String> destination) {
	            this.destination = destination;
	        }
	
	        /**
	         * @param destination destination for email
	         * @return Mail
	         */
	        public Mail withDestination(List<String> destination) {
	            setDestination(destination);
	            return this;
	        }
	
	        /**
	         * check if headers are truncated
	         * @return boolean if headers are truncated
	         */
	        public Boolean getHeadersTruncated() {
	            return headersTruncated;
	        }
	
	        /**
	         * set whether headers should be truncateds
	         * @param headersTruncated booolean whether headers should be truncated
	         */
	        public void setHeadersTruncated(Boolean headersTruncated) {
	            this.headersTruncated = headersTruncated;
	        }
	
	        /**
	         * @param headersTruncated header truncated
	         * @return Mail
	         */
	        public Mail withHeadersTruncated(Boolean headersTruncated) {
	            setHeadersTruncated(headersTruncated);
	            return this;
	        }
	
	        /**
	         * get list of headers
	         * @return List of headers
	         */
	        public List<Header> getHeaders() {
	            return this.headers;
	        }
	
	        /**
	         * set headers
	         * @param headers List of Headers
	         */
	        public void setHeaders(List<Header> headers) {
	            this.headers = headers;
	        }
	
	        /**
	         * @param headers headers of email
	         * @return Mail
	         */
	        public Mail withHeaders(List<Header> headers) {
	            setHeaders(headers);
	            return this;
	        }
	
	        /**
	         * get Common headers
	         * @return CommonHeaders
	         */
	        public CommonHeaders getCommonHeaders() {
	            return this.commonHeaders;
	        }
	
	        /**
	         * set common headers
	         * @param commonHeaders common headers in mail
	         */
	        public void setCommonHeaders(CommonHeaders commonHeaders) {
	            this.commonHeaders = commonHeaders;
	        }
	
	        /**
	         * @param commonHeaders common headers in mail
	         * @return Mail
	         */
	        public Mail withCommonHeaders(CommonHeaders commonHeaders) {
	            setCommonHeaders(commonHeaders);
	            return this;
	        }
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         *
	         * @return A string representation of this object.
	         *
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getTimestamp() != null) {
	                sb.append("timestamp: ").append(getTimestamp().toString()).append(",");
	            }
	            if (getMessageId() != null) {
	                sb.append("messageId: ").append(getMessageId()).append(",");
	            }
	            if (getSource() != null) {
	                sb.append("source: ").append(getSource()).append(",");
	            }
	            if (getSourceArn() != null) {
	                sb.append("sourceArn: ").append(getSourceArn()).append(",");
	            }
	            if (getSourceIp() != null) {
	                sb.append("sourceIp: ").append(getSourceIp()).append(",");
	            }
	            if (getDestination() != null) {
	                sb.append("destination: ").append(getDestination()).append(",");
	            }
	            if (getHeadersTruncated() != null) {
	                sb.append("headersTruncated: ").append(getHeadersTruncated().toString()).append(",");
	            }
	            if (getHeaders() != null) {
	                sb.append("headers: ").append(getHeaders().toString()).append(",");
	            }
	            if (getCommonHeaders() != null) {
	                sb.append("commonHeaders: ").append(getCommonHeaders().toString());
	            }
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (obj == null) {
	                return false;
	            }
	
	            if (!(obj instanceof Mail)) {
	                return false;
	            }
	            Mail other = (Mail) obj;
	            return !((other.getTimestamp() == null ^ this.getTimestamp() == null)
	                || (other.getTimestamp() != null && !other.getTimestamp().equals(this.getTimestamp()))
	                || (other.getMessageId() == null ^ this.getMessageId() == null)
	                || (other.getMessageId() != null && !other.getMessageId().equals(this.getMessageId()))
	                || (other.getSource() == null ^ this.getSource() == null)
	                || (other.getSource() != null && !other.getSource().equals(this.getSource()))
	                || (other.getSourceArn() == null ^ this.getSourceArn() == null)
	                || (other.getSourceArn() != null && !other.getSourceArn().equals(this.getSourceArn()))
	                || (other.getSourceIp() == null ^ this.getSourceIp() == null)
	                || (other.getSourceIp() != null && !other.getSourceIp().equals(this.getSourceIp()))
	                || (other.getDestination() == null ^ this.getDestination() == null)
	                || (other.getDestination() != null && !other.getDestination().equals(this.getDestination()))
	                || (other.getHeadersTruncated() == null ^ this.getHeadersTruncated() == null)
	                || (other.getHeadersTruncated() != null && !other.getHeadersTruncated().equals(this.getHeadersTruncated()))
	                || (other.getHeaders() == null ^ this.getHeaders() == null)
	                || (other.getHeaders() != null && !other.getHeaders().equals(this.getHeaders()))
	                || (other.getCommonHeaders() == null ^ this.getCommonHeaders() == null)
	                || (other.getCommonHeaders() != null && !other.getCommonHeaders().equals(this.getCommonHeaders())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
	            hashCode = prime * hashCode + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
	            hashCode = prime * hashCode + ((getSource() == null) ? 0 : getSource().hashCode());
	            hashCode = prime * hashCode + ((getSourceArn() == null) ? 0 : getSourceArn().hashCode());
	            hashCode = prime * hashCode + ((getSourceIp() == null) ? 0 : getSourceIp().hashCode());
	            hashCode = prime * hashCode + ((getDestination() == null) ? 0 : getDestination().hashCode());
	            hashCode = prime * hashCode + ((getHeadersTruncated() == null) ? 0 : getHeadersTruncated().hashCode());
	            hashCode = prime * hashCode + ((getHeaders() == null) ? 0 : getHeaders().hashCode());
	            hashCode = prime * hashCode + ((getCommonHeaders() == null) ? 0 : getCommonHeaders().hashCode());
	            return hashCode;
	        }
	
	        @Override
	        public Mail clone() {
	            try {
	                return (Mail) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() ", e);
	            }
	        }
	
	    }
	
	    /**
	     * Represents BounceRecipient
	     */
	    public static class BounceRecipient implements Serializable, Cloneable {
			private static final long serialVersionUID = 1160471637194356329L;
			private String emailAddress;
	        private String action;
	        private String status;
	        private String diagnosticCode;
	
	        /**
	         * get email address
	         * @return email address
	         */
	        public String getEmailAddress() {
	            return this.emailAddress;
	        }
	
	        /**
	         * set email address
	         * @param emailAddress String email address
	         */
	        public void setEmailAddress(String emailAddress) {
	            this.emailAddress = emailAddress;
	        }
	
	        /**
	         * @param emailAddress email address bounced
	         * @return BounceRecipient
	         */
	        public BounceRecipient withEmailAddress(String emailAddress) {
	            setEmailAddress(emailAddress);
	            return this;
	        }
	
	        /**
	         * get action
	         * @return String action
	         */
	        public String getAction() {
	            return this.action;
	        }
	
	        /**
	         * set action
	         * @param action String action
	         */
	        public void setAction(String action) {
	            this.action = action;
	        }
	
	        /**
	         * @param action action
	         * @return BounceRecipient
	         */
	        public BounceRecipient withAction(String action) {
	            setAction(action);
	            return this;
	        }
	
	        /**
	         * get status
	         * @return String status
	         */
	        public String getStatus() {
	            return this.status;
	        }
	
	        /**
	         * set status
	         * @param status String status
	         */
	        public void setStatus(String status) {
	            this.status = status;
	        }
	
	        /**
	         * @param status bounce recipient status
	         * @return BounceRecipient
	         */
	        public BounceRecipient withStatus(String status) {
	            setStatus(status);
	            return this;
	        }
	
	        /**
	         * get diagnostic code
	         * @return String diagnostic code
	         */
	        public String getDiagnosticCode() {
	            return diagnosticCode;
	        }
	
	        /**
	         * set diagnostic code
	         * @param diagnosticCode String diagnostic code
	         */
	        public void setDiagnosticCode(String diagnosticCode) {
	            this.diagnosticCode = diagnosticCode;
	        }
	
	        /**
	         * @param diagnosticCode diagnostic code
	         * @return BounceRecipient
	         */
	        public BounceRecipient withDiagnosticCode(String diagnosticCode) {
	            setDiagnosticCode(diagnosticCode);
	            return this;
	        }
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         *
	         * @return A string representation of this object.
	         *
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getEmailAddress() != null)
	                sb.append("emailAddress: ").append(getEmailAddress()).append(",");
	            if (getAction() != null)
	                sb.append("action: ").append(getAction()).append(",");
	            if (getStatus() != null)
	                sb.append("status: ").append(getStatus()).append(",");
	            if (getDiagnosticCode() != null)
	                sb.append("diagnosticCode: ").append(getDiagnosticCode());
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (obj == null) {
	                return false;
	            }
	
	            if (!(obj instanceof BounceRecipient)) {
	                return false;
	            }
	            BounceRecipient other = (BounceRecipient) obj;
	            return !((other.getEmailAddress() == null ^ this.getEmailAddress() == null)
	                || (other.getEmailAddress() != null && !other.getEmailAddress().equals(this.getEmailAddress()))
	                || (other.getAction() == null ^ this.getAction() == null)
	                || (other.getAction() != null && !other.getAction().equals(this.getAction()))
	                || (other.getStatus() == null ^ this.getStatus() == null)
	                || (other.getStatus() != null && !other.getStatus().equals(this.getStatus()))
	                || (other.getDiagnosticCode() == null ^ this.getDiagnosticCode() == null)
	                || (other.getDiagnosticCode() != null && !other.getDiagnosticCode().equals(this.getDiagnosticCode())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getEmailAddress() == null) ? 0 : getEmailAddress().hashCode());
	            hashCode = prime * hashCode + ((getAction() == null) ? 0 : getAction().hashCode());
	            hashCode = prime * hashCode + ((getStatus() == null) ? 0 : getStatus().hashCode());
	            hashCode = prime * hashCode + ((getDiagnosticCode() == null) ? 0 : getDiagnosticCode().hashCode());
	            return hashCode;
	        }
	
	        @Override
	        public BounceRecipient clone() {
	            try {
	                return (BounceRecipient) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException("Got a CloneNotSupportedException emailAddress Object.clone() " + "even though we're Cloneable!", e);
	            }
	        }
	
	    }
	

	    public static class Bounce implements Serializable, Cloneable {
			private static final long serialVersionUID = -3788166805822951342L;
			private String bounceType;
	        private String bounceSubType;
	        private List<BounceRecipient> bouncedRecipients;
	        private DateTime timestamp;
	        private String feedbackId;
	        private String remoteMtaIp;
	        private String reportingMta;
	
	        /**
	         * get bounce type
	         * @return String bounce type
	         */
	        public String getBounceType() {
	            return this.bounceType;
	        }
	
	        /**
	         * set bounce type
	         * @param bounceType String bounce type
	         */
	        public void setBounceType(String bounceType) {
	            this.bounceType = bounceType;
	        }
	
	        /**
	         * @param bounceType bounce type
	         * @return Bounce
	         */
	        public Bounce withBounceType(String bounceType) {
	            setBounceType(bounceType);
	            return this;
	        }
	
	        /**
	         * get bounce subType
	         * @return String bounce subtype
	         */
	        public String getBounceSubType() {
	            return this.bounceSubType;
	        }
	
	        /**
	         * set bounce sub type
	         * @param bounceSubType String bounce sub type
	         */
	        public void setBounceSubType(String bounceSubType) {
	            this.bounceSubType = bounceSubType;
	        }
	
	        /**
	         * @param bounceSubType bounce sub typer
	         * @return Bounce
	         */
	        public Bounce withBounceSubType(String bounceSubType) {
	            setBounceType(bounceType);
	            return this;
	        }
	
	        /**
	         * get bounced recipients
	         * @return List of recipients
	         */
	        public List<BounceRecipient> getBouncedRecipients() {
	            return this.bouncedRecipients;
	        }
	
	        /**
	         * set bounced recipients
	         * @param bouncedRecipients List of recipients
	         */
	        public void setBouncedRecipients(List<BounceRecipient> bouncedRecipients) {
	            this.bouncedRecipients = bouncedRecipients;
	        }
	
	        /**
	         * @param bounceRecipients bounced recipients
	         * @return Bounce
	         */
	        public Bounce withBounceRecipients(List<BounceRecipient> bounceRecipients) {
	            setBouncedRecipients(bounceRecipients);
	            return this;
	        }
	
	        /**
	         * get timestampe
	         * @return String when bounce happened
	         */
	        public DateTime getTimestamp() {
	            return this.timestamp;
	        }
	
	        /**
	         * set timestamp when bounce happened
	         * @param timestamp String when bounce happened
	         */
	        public void setTimestamp(DateTime timestamp) {
	            this.timestamp = timestamp;
	        }
	
	        /**
	         * @param timestamp timestamp of bounce
	         * @return Bounce
	         */
	        public Bounce withTimestamp(DateTime timestamp) {
	            setTimestamp(timestamp);
	            return this;
	        }
	
	        /**
	         * get feedback id
	         * @return String feedback id
	         */
	        public String getFeedbackId() {
	            return this.feedbackId;
	        }
	
	        /**
	         * set feedback id
	         * @param feedbackId String feedback id
	         */
	        public void setFeedbackId(String feedbackId) {
	            this.feedbackId = feedbackId;
	        }
	
	        /**
	         * @param feedbackId feedback id
	         * @return Bounce
	         */
	        public Bounce withFeedbackId(String feedbackId) {
	            setFeedbackId(feedbackId);
	            return this;
	        }
	
	        /**
	         * get remote mta ip
	         * @return String mta ip address
	         */
	        public String getRemoteMtaIp() {
	            return this.remoteMtaIp;
	        }
	
	        /**
	         * set remote mta ip
	         * @param remoteMtaIp String mta ip address
	         */
	        public void setRemoteMtaIp(String remoteMtaIp) {
	            this.remoteMtaIp = remoteMtaIp;
	        }
	
	        /**
	         * @param remoteMtaIp remote mta ip address
	         * @return Bounce
	         */
	        public Bounce withRemoteMtaIp(String remoteMtaIp) {
	            setRemoteMtaIp(remoteMtaIp);
	            return this;
	        }
	
	        /**
	         * get reporting mta
	         * @return STring reporting mta
	         */
	        public String getReportingMta() {
	            return reportingMta;
	        }
	
	        /**
	         * set reporting mta
	         * @param reportingMta String with mta
	         */
	        public void setReportingMta(String reportingMta) {
	            this.reportingMta = reportingMta;
	        }
	
	        /**
	         * @param reportingMta reporting mta
	         * @return Bounce
	         */
	        public Bounce withReportingMta(String reportingMta) {
	            setReportingMta(reportingMta);
	            return this;
	        }
	
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         *
	         * @return A string representation of this object.
	         *
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getBounceType() != null)
	                sb.append("bounceType: ").append(getBounceType()).append(",");
	            if (getBounceSubType() != null)
	                sb.append("bounceSubType: ").append(getBounceSubType()).append(",");
	            if (getBouncedRecipients() != null)
	                sb.append("bouncedRecipients: ").append(getBouncedRecipients().toString()).append(",");
	            if (getTimestamp() != null)
	                sb.append("timestamp: ").append(getTimestamp().toString()).append(",");
	            if (getFeedbackId() != null)
	                sb.append("feedbackId: ").append(getFeedbackId()).append(",");
	            if (getRemoteMtaIp() != null)
	                sb.append("remoteMtaIp: ").append(getRemoteMtaIp()).append(",");
	            if (getReportingMta() != null)
	                sb.append("reportingMta: ").append(getReportingMta());
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (!(obj instanceof Bounce)) {
	                return false;
	            }
	
	            Bounce other = (Bounce) obj;
	            return !((other.getBounceType() == null ^ this.getBounceType() == null)
	            	|| (other.getBounceType() != null && !other.getBounceType().equals(this.getBounceType()))
	                || (other.getBounceSubType() == null ^ this.getBounceSubType() == null)
	                || (other.getBounceSubType() != null && !other.getBounceSubType().equals(this.getBounceSubType()))
	                || (other.getBouncedRecipients() == null ^ this.getBouncedRecipients() == null)
	                || (other.getTimestamp() == null ^ this.getTimestamp() == null)
	                || (other.getTimestamp() != null && !other.getTimestamp().equals(this.getTimestamp()))
	                || (other.getBouncedRecipients() != null && !other.getBouncedRecipients().equals(this.getBouncedRecipients()))
	                || (other.getFeedbackId() == null ^ this.getFeedbackId() == null)
	                || (other.getFeedbackId() != null && !other.getFeedbackId().equals(this.getFeedbackId()))
	                || (other.getRemoteMtaIp() == null ^ this.getRemoteMtaIp() == null)
	                || (other.getRemoteMtaIp() != null && !other.getRemoteMtaIp().equals(this.getRemoteMtaIp()))
	                || (other.getReportingMta() == null ^ this.getReportingMta() == null)
	                || (other.getReportingMta() != null && !other.getReportingMta().equals(this.getReportingMta())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getBounceType() == null) ? 0 : getBounceType().hashCode());
	            hashCode = prime * hashCode + ((getBounceSubType() == null) ? 0 : getBounceSubType().hashCode());
	            hashCode = prime * hashCode + ((getBouncedRecipients() == null) ? 0 : getBouncedRecipients().hashCode());
	            hashCode = prime * hashCode + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
	            hashCode = prime * hashCode + ((getFeedbackId() == null) ? 0 : getFeedbackId().hashCode());
	            hashCode = prime * hashCode + ((getRemoteMtaIp() == null) ? 0 : getRemoteMtaIp().hashCode());
	            hashCode = prime * hashCode + ((getReportingMta() == null) ? 0 : getReportingMta().hashCode());
	            return hashCode;
	        }
	
	        @Override
	        public Bounce clone() {
	            try {
	                return (Bounce) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException("Got a CloneNotSupportedException Object.clone() ", e);
	            }
	        }
	
	    }
	
	    /**
	     * class representing recipient of a complaint
	     */
	    public static class ComplainedRecipient implements Serializable, Cloneable {
	
			private static final long serialVersionUID = -447419795155744341L;
			private String emailAddress;
	
	        /**
	         * get email address
	         * @return String email address
	         */
	        public String getEmailAddress() {
	            return this.emailAddress;
	        }
	
	        /**
	         * set email address
	         * @param emailAddress String email address
	         */
	        public void setEmailAddress(String emailAddress) {
	            this.emailAddress = emailAddress;
	        }
	
	        public ComplainedRecipient withEmailAddress(String emailAddress) {
	            setEmailAddress(emailAddress);
	            return this;
	        }
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         *
	         * @return A string representation of this object.
	         *
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getEmailAddress() != null) {
	                sb.append("emailAddress: ").append(getEmailAddress());
	            }
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (obj == null) {
	                return false;
	            }
	
	            if (!(obj instanceof ComplainedRecipient)) {
	                return false;
	            }
	            ComplainedRecipient other = (ComplainedRecipient) obj;
	            return !((other.getEmailAddress() == null ^ this.getEmailAddress() == null)
	            		|| (other.getEmailAddress() != null && !other.getEmailAddress().equals(this.getEmailAddress())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getEmailAddress() == null) ? 0 : getEmailAddress().hashCode());
	            return hashCode;
	        }
	
	        @Override
	        public ComplainedRecipient clone() {
	            try {
	                return (ComplainedRecipient) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
	            }
	        }
	
	    }
	
	    public static class Complaint implements Serializable, Cloneable {
			private static final long serialVersionUID = 7408780599324153081L;
			private List<ComplainedRecipient> complainedRecipients;
	        private DateTime timestamp;
	        private String feedbackId;
	        private String userAgent;
	        private String complaintFeedbackType;
	        private String arrivalDate;
	
	        /**
	         * return lis of complaint recipients
	         * @return List of BounceRecipient
	         */
	        public List<ComplainedRecipient> getComplainedRecipients() {
	            return this.complainedRecipients;
	        }
	
	        /**
	         * set complaint recipients
	         * @param complainedRecipients List of Recipients
	         */
	        public void setComplainedRecipients(List<ComplainedRecipient> complainedRecipients) {
	            this.complainedRecipients = complainedRecipients;
	        }
	
	        /**
	         * @param complainedRecipients complained recipients
	         * @return Complaint
	         */
	        public Complaint withComplainedRecipients(List<ComplainedRecipient> complainedRecipients) {
	            setComplainedRecipients(complainedRecipients);
	            return this;
	        }
	
	        /**
	         * return datetime that message was sent at
	         * @return String when message was sent
	         */
	        public DateTime getTimestamp() {
	            return this.timestamp;
	        }
	
	        /**
	         * set tinestamp on complaint message
	         * @param timestamp timestamp when message was sent
	         */
	        public void setTimestamp(DateTime timestamp) {
	            this.timestamp = timestamp;
	        }
	
	        /**
	         * @param timestamp timestamp
	         * @return Complaint
	         */
	        public Complaint withTimestamp(DateTime timestamp) {
	            setTimestamp(timestamp);
	            return this;
	        }
	
	        /**
	         * get feedback id
	         * @return String with feedback id
	         */
	        public String getFeedbackId() {
	            return this.feedbackId;
	        }
	
	        /**
	         * set feedback id
	         * @param feedbackId String with feedback id
	         */
	        public void setFeedbackId(String feedbackId) {
	            this.feedbackId = feedbackId;
	        }
	
	        /**
	         * @param feedbackId feedback id
	         * @return Complaint
	         */
	        public Complaint withFeedbackId(String feedbackId) {
	            setFeedbackId(feedbackId);
	            return this;
	        }
	
	        /**
	         * get user agent
	         * @return String user agent
	         */
	        public String getUserAgent() {
	            return this.userAgent;
	        }
	
	        /**
	         * set user agent
	         * @param userAgent String user agent
	         */
	        public void setUserAgent(String userAgent) {
	            this.userAgent = userAgent;
	        }
	
	        /**
	         * @param userAgent user agent
	         * @return Complaint
	         */
	        public Complaint withUserAgent(String userAgent) {
	            setUserAgent(userAgent);
	            return this;
	        }
	
	        /**
	         * get complaint feed back type
	         * @return String complaint feedback type
	         */
	        public String getComplaintFeedbackType() {
	            return this.complaintFeedbackType;
	        }
	
	        /**
	         * set complaint feedback type
	         * @param complaintFeedbackType String complaint feedback type
	         */
	        public void setComplaintFeedbackType(String complaintFeedbackType) {
	            this.complaintFeedbackType = complaintFeedbackType;
	        }
	
	        /**
	         * @param complaintFeedbackType copmlaint feedback type
	         * @return Complaint
	         */
	        public Complaint withComplaintFeedbackType(String complaintFeedbackType) {
	            setComplaintFeedbackType(complaintFeedbackType);
	            return this;
	        }
	
	        /**
	         * get message arrival date
	         * @return String when message arrived
	         */
	        public String getArrivalDate() {
	            return this.arrivalDate;
	        }
	
	        /**
	         * set arrival date
	         * @param arrivalDate when message arrives
	         */
	        public void setArrivalDate(String arrivalDate) {
	            this.arrivalDate = arrivalDate;
	        }
	
	        /**
	         * @param arrivalDate arrival date
	         * @return Complaint
	         */
	        public Complaint withArrivalDate(String arrivalDate) {
	            setArrivalDate(arrivalDate);
	            return this;
	        }
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         *
	         * @return A string representation of this object.
	         *
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getComplainedRecipients() != null)
	                sb.append("complainedRecipients: ").append(getComplainedRecipients().toString()).append(",");
	            if (getTimestamp() != null)
	                sb.append("timestamp: ").append(getTimestamp().toString()).append(",");
	            if (getFeedbackId() != null)
	                sb.append("feedbackId: ").append(getFeedbackId()).append(",");
	            if (getUserAgent() != null)
	                sb.append("userAgent: ").append(getUserAgent()).append(",");
	            if (getComplaintFeedbackType() != null)
	                sb.append("complaintFeedbackType: ").append(getComplaintFeedbackType()).append(",");
	            if (getArrivalDate() != null)
	                sb.append("arrivalDate: ").append(getArrivalDate());
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (obj == null) {
	                return false;
	            }
	
	            if (!(obj instanceof Complaint)) {
	                return false;
	            }
	            Complaint other = (Complaint) obj;
	            return !((other.getComplainedRecipients() == null ^ this.getComplainedRecipients() == null)
	                || (other.getComplainedRecipients() != null && !other.getComplainedRecipients().equals(this.getComplainedRecipients()))
	                || (other.getTimestamp() == null ^ this.getTimestamp() == null)
	                || (other.getTimestamp() != null && !other.getTimestamp().equals(this.getTimestamp()))
	                || (other.getFeedbackId() == null ^ this.getFeedbackId() == null)
	                || (other.getFeedbackId() != null && !other.getFeedbackId().equals(this.getFeedbackId()))
	                || (other.getUserAgent() == null ^ this.getUserAgent() == null)
	                || (other.getUserAgent() != null && !other.getUserAgent().equals(this.getUserAgent()))
	                || (other.getComplaintFeedbackType() == null ^ this.getComplaintFeedbackType() == null)
	                || (other.getComplaintFeedbackType() != null && !other.getComplaintFeedbackType().equals(this.getComplaintFeedbackType()))
	                || (other.getArrivalDate() == null ^ this.getArrivalDate() == null)
	                || (other.getArrivalDate() != null && !other.getArrivalDate().equals(this.getArrivalDate())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getComplainedRecipients() == null) ? 0 : getComplainedRecipients().hashCode());
	            hashCode = prime * hashCode + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
	            hashCode = prime * hashCode + ((getFeedbackId() == null) ? 0 : getFeedbackId().hashCode());
	            hashCode = prime * hashCode + ((getUserAgent() == null) ? 0 : getUserAgent().hashCode());
	            hashCode = prime * hashCode + ((getComplaintFeedbackType() == null) ? 0 : getComplaintFeedbackType().hashCode());
	            hashCode = prime * hashCode + ((getArrivalDate() == null) ? 0 : getArrivalDate().hashCode());
	            return hashCode;
	        }
	
	        @Override
	        public Complaint clone() {
	            try {
	                return (Complaint) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException("Got a CloneNotSupportedException timestamp Object.clone() ", e);
	            }
	        }
	
	    }
	
	    public static class Delivery implements Serializable, Cloneable {
			private static final long serialVersionUID = -7294556585658821156L;
			private DateTime timestamp;
	        private Integer processingTimeMillis;
	        private List<String> recipients;
	        private String smtpResponse;
	        private String reportingMta;
	        private String remoteMtaIp;
	
	        /**
	         * return timestamp of message
	         * @return Date with timestamp
	         */
	        public DateTime getTimestamp() {
	            return this.timestamp;
	        }
	
	        /**
	         * set timestamp of message
	         * @param timestamp Date of message
	         */
	        public void setTimestamp(DateTime timestamp) {
	            this.timestamp = timestamp;
	        }
	
	        /**
	         * @param timestamp Date of message
	         * @return Delivery object
	         */
	        public Delivery withTimestamp(DateTime timestamp) {
	            setTimestamp(timestamp);
	            return this;
	        }
	
	        /**
	         * get processing time in ms
	         * @return int with processing time
	         */
	        public Integer getProcessingTimeMillis() {
	            return this.processingTimeMillis;
	        }
	
	        /**
	         * set processing time in ms
	         * @param processingTimeMillis int time in ms
	         */
	        public void setProcessingTimeMillis(Integer processingTimeMillis) {
	            this.processingTimeMillis = processingTimeMillis;
	        }
	
	        /**
	         * @param processingTimeMillis time in ms
	         * @return Delivery
	         */
	        public Delivery withProcessingTimeMillis(Integer processingTimeMillis) {
	            setProcessingTimeMillis(processingTimeMillis);
	            return this;
	        }
	
	        /**
	         * set list of recipients
	         * @return List of String with email addresses
	         */
	        public List<String> getRecipients() {
	            return recipients;
	        }
	
	        /**
	         * set the list of recipients
	         * @param recipients recipients of email
	         */
	        public void setRecipients(List<String> recipients) {
	            this.recipients = recipients;
	        }
	
	        /**
	         * @param recipients recipients of delivery
	         * @return Delivery
	         */
	        public Delivery withRecipients(List<String> recipients) {
	            setRecipients(recipients);
	            return this;
	        }
	
	        /**
	         * get smtp response
	         * @return String smpt response
	         */
	        public String getSmtpResponse() {
	            return this.smtpResponse;
	        }
	
	        /**
	         * set smtp response
	         * @param smtpResponse String smtp response
	         */
	        public void setSmtpResponse(String smtpResponse) {
	            this.smtpResponse = smtpResponse;
	        }
	
	        /**
	         * @param smtpResponse smtp response
	         * @return Delivery
	         */
	        public Delivery withSmtpResponse(String smtpResponse) {
	            setSmtpResponse(smtpResponse);
	            return this;
	        }
	
	        /**
	         * get reporting mta
	         * @return String with mta
	         */
	        public String getReportingMta() {
	            return this.reportingMta;
	        }
	
	        /**
	         * set reporting mta
	         * @param reportingMta STring with mta
	         */
	        public void setReportingMta(String reportingMta) {
	            this.reportingMta = reportingMta;
	        }
	
	        /**
	         * @param reportingMta reporting mta
	         * @return Delivery
	         */
	        public Delivery withReportingMta(String reportingMta) {
	            setReportingMta(reportingMta);
	            return this;
	        }
	
	        /**
	         * get remote mta ip address
	         * @return String with mta ip address
	         */
	        public String getRemoteMtaIp() {
	            return this.remoteMtaIp;
	        }
	
	        /**
	         * set remote mta ip address
	         * @param remoteMtaIp String with ip address
	         */
	        public void setRemoteMtaIp(String remoteMtaIp) {
	            this.remoteMtaIp = remoteMtaIp;
	        }
	
	        /**
	         * @param remoteMtaIp remote mta ip
	         * @return Delivery
	         */
	        public Delivery withRemoteMtaIp(String remoteMtaIp) {
	            setRemoteMtaIp(remoteMtaIp);
	            return this;
	        }
	
	        /**
	         * Returns a string representation of this object; useful for testing and debugging.
	         * @return A string representation of this object.
	         * @see Object#toString()
	         */
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if (getTimestamp() != null) {
	                sb.append("timestamp: ").append(getTimestamp().toString()).append(",");
	            }
	            if (getProcessingTimeMillis() != null) {
	                sb.append("processingTimeMillis: ").append(getProcessingTimeMillis().toString()).append(",");
	            }
	            if (getRecipients() != null) {
	                sb.append("recipients: ").append(getRecipients()).append(",");
	            }
	            if (getSmtpResponse() != null) {
	                sb.append("smtpResponse: ").append(getSmtpResponse()).append(",");
	            }
	            if (getReportingMta() != null) {
	                sb.append("reportingMta: ").append(getReportingMta()).append(",");
	            }
	            if (getRemoteMtaIp() != null) {
	                sb.append("remoteMtaIp: ").append(getRemoteMtaIp());
	            }
	            sb.append("}");
	            return sb.toString();
	        }
	
	        @Override
	        public boolean equals(Object obj) {
	            if (this == obj) {
	                return true;
	            } else if (obj == null) {
	                return false;
	            }
	
	            if (!(obj instanceof Delivery)) {
	                return false;
	            }
	            Delivery other = (Delivery) obj;
	            return !((other.getTimestamp() == null ^ this.getTimestamp() == null)
	                || (other.getTimestamp() != null && !other.getTimestamp().equals(this.getTimestamp()))
	                || (other.getProcessingTimeMillis() == null ^ this.getProcessingTimeMillis() == null)
	                || (other.getProcessingTimeMillis() != null && !other.getProcessingTimeMillis().equals(this.getProcessingTimeMillis()))
	                || (other.getRecipients() == null ^ this.getRecipients() == null)
	                || (other.getRecipients() != null && !other.getRecipients().equals(this.getRecipients()))
	                || (other.getSmtpResponse() == null ^ this.getSmtpResponse() == null)
	                || (other.getSmtpResponse() != null && !other.getSmtpResponse().equals(this.getSmtpResponse()))
	                || (other.getReportingMta() == null ^ this.getReportingMta() == null)
	                || (other.getReportingMta() != null && !other.getReportingMta().equals(this.getReportingMta()))
	                || (other.getRemoteMtaIp() == null ^ this.getRemoteMtaIp() == null)
	                || (other.getRemoteMtaIp() != null && !other.getRemoteMtaIp().equals(this.getRemoteMtaIp())));
	        }
	
	        @Override
	        public int hashCode() {
	            final int prime = 31;
	            int hashCode = 1;
	
	            hashCode = prime * hashCode + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
	            hashCode = prime * hashCode + ((getProcessingTimeMillis() == null) ? 0 : getProcessingTimeMillis().hashCode());
	            hashCode = prime * hashCode + ((getRecipients() == null) ? 0 : getRecipients().hashCode());
	            hashCode = prime * hashCode + ((getSmtpResponse() == null) ? 0 : getSmtpResponse().hashCode());
	            hashCode = prime * hashCode + ((getReportingMta() == null) ? 0 : getReportingMta().hashCode());
	            hashCode = prime * hashCode + ((getRemoteMtaIp() == null) ? 0 : getRemoteMtaIp().hashCode());
	            return hashCode;
	        }
	
	        @Override
	        public Delivery clone() {
	            try {
	                return (Delivery) super.clone();
	            } catch (CloneNotSupportedException e) {
	                throw new IllegalStateException("Got a CloneNotSupportedException Object.clone() ", e);
	            }
	        }
	
	    }
	
	    private String		notificationType;
	    private Mail		mail;
	    private Bounce		bounce;
	    private Complaint	complaint;
	    private Delivery	delivery;
	
	    /**
	     * get the notification type
	     * @return String notification type
	     */
	    public String getNotificationType() {
	        return this.notificationType;
	    }
	
	    /**
	     * set the notification type
	     * @param notificationType String notification type
	     */
	    public void setNotificationType(String notificationType) {
	        this.notificationType = notificationType;
	    }
	
	    /**
	     * @param notificationType notification type
	     * @return SESEvent
	     */
	    public SES withNotificationType(String notificationType) {
	        setNotificationType(notificationType);
	        return this;
	    }
	
	    /**
	     * get mail
	     * @return Mail object
	     */
	    public Mail getMail() {
	        return this.mail;
	    }
	
	    /**
	     * set mail object
	     * @param mail Mail object
	     */
	    public void setMail(Mail mail) {
	        this.mail = mail;
	    }
	
	    /**
	     * @param mail Mail object
	     * @return SESEvent
	     */
	    public SES withMail(Mail mail) {
	        setMail(mail);
	        return this;
	    }
	
	    /**
	     * set bounce object
	     * @return Bounce object
	     */
	    public Bounce getBounce() {
	        return this.bounce;
	    }
	
	    /**
	     * set bounce object
	     * @param bounce Bounce
	     */
	    public void setBounce(Bounce bounce) {
	        this.bounce = bounce;
	    }
	
	    /**
	     * @param bounce Bounce
	     * @return SESEvent
	     */
	    public SES withBounce(Bounce bounce) {
	        setBounce(bounce);
	        return this;
	    }
	
	    /**
	     * get complaint
	     * @return Complaint object
	     */
	    public Complaint getComplaint() {
	        return this.complaint;
	    }
	
	    /**
	     * set complaint
	     * @param complaint Complaint object
	     */
	    public void setComplaint(Complaint complaint) {
	        this.complaint = complaint;
	    }
	
	    /**
	     * @param complaint Complaint
	     * @return SESEvent
	     */
	    public SES withComplaint(Complaint complaint) {
	        setComplaint(complaint);
	        return this;
	    }
	
	    /**
	     * get delivery info
	     * @return Delivery object
	     */
	    public Delivery getDelivery() {
	        return this.delivery;
	    }
	
	    /**
	     * set delivery info
	     * @param delivery Delivery object
	     */
	    public void setDelivery(Delivery delivery) {
	        this.delivery = delivery;
	    }
	
	    /**
	     * @param delivery Delivery object
	     * @return SESEvent
	     */
	    public SES withDelivery(Delivery delivery) {
	        setDelivery(delivery);
	        return this;
	    }
	
	
	    /**
	     * Returns a string representation of this object; useful for testing and debugging.
	     * @return A string representation of this object.
	     * @see Object#toString()
	     */
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("{");
	        if (getNotificationType() != null)
	            sb.append("notificationType: ").append(getNotificationType()).append(",");
	        if (getMail() != null)
	            sb.append("mail: ").append(getMail().toString()).append(",");
	        if (getBounce() != null)
	            sb.append("bounce: ").append(getBounce().toString()).append(",");
	        if (getComplaint() != null)
	            sb.append("complaint: ").append(getComplaint().toString()).append(",");
	        if (getDelivery() != null)
	            sb.append("delivery: ").append(getDelivery().toString());
	        sb.append("}");
	        return sb.toString();
	    }
	
	
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int hashCode = 1;
	
	        hashCode = prime * hashCode + ((getNotificationType() == null) ? 0 : getNotificationType().hashCode());
	        hashCode = prime * hashCode + ((getMail() == null) ? 0 : getMail().hashCode());
	        hashCode = prime * hashCode + ((getBounce() == null) ? 0 : getBounce().hashCode());
	        hashCode = prime * hashCode + ((getComplaint() == null) ? 0 : getComplaint().hashCode());
	        hashCode = prime * hashCode + ((getDelivery() == null) ? 0 : getDelivery().hashCode());
	        return hashCode;
	    }
	
	    @Override
	    public SESEvent clone() {
	        try {
	            return (SESEvent) super.clone();
	        } catch (CloneNotSupportedException e) {
	            throw new IllegalStateException("Got a CloneNotSupportedException notificationType Object.clone() ", e);
	        }
	    }
    }
}
