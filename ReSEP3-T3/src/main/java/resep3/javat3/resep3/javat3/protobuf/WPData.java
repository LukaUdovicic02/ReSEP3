// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WorkoutPlan.proto

package resep3.javat3.protobuf;

/**
 * Protobuf type {@code WPData}
 */
public final class WPData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:WPData)
    WPDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WPData.newBuilder() to construct.
  private WPData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WPData() {
    wpname_ = "";
    type_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WPData();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WPData(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            wpid_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            wpname_ = s;
            break;
          }
          case 24: {

            timegoal_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            type_ = s;
            break;
          }
          case 40: {

            userid_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return resep3.javat3.protobuf.WorkoutPlan.internal_static_WPData_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return resep3.javat3.protobuf.WorkoutPlan.internal_static_WPData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            resep3.javat3.protobuf.WPData.class, resep3.javat3.protobuf.WPData.Builder.class);
  }

  public static final int WPID_FIELD_NUMBER = 1;
  private int wpid_;
  /**
   * <code>int32 wpid = 1;</code>
   * @return The wpid.
   */
  @java.lang.Override
  public int getWpid() {
    return wpid_;
  }

  public static final int WPNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object wpname_;
  /**
   * <code>string wpname = 2;</code>
   * @return The wpname.
   */
  @java.lang.Override
  public java.lang.String getWpname() {
    java.lang.Object ref = wpname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      wpname_ = s;
      return s;
    }
  }
  /**
   * <code>string wpname = 2;</code>
   * @return The bytes for wpname.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getWpnameBytes() {
    java.lang.Object ref = wpname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      wpname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMEGOAL_FIELD_NUMBER = 3;
  private int timegoal_;
  /**
   * <code>int32 timegoal = 3;</code>
   * @return The timegoal.
   */
  @java.lang.Override
  public int getTimegoal() {
    return timegoal_;
  }

  public static final int TYPE_FIELD_NUMBER = 4;
  private volatile java.lang.Object type_;
  /**
   * <code>string type = 4;</code>
   * @return The type.
   */
  @java.lang.Override
  public java.lang.String getType() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <code>string type = 4;</code>
   * @return The bytes for type.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTypeBytes() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERID_FIELD_NUMBER = 5;
  private int userid_;
  /**
   * <code>int32 userid = 5;</code>
   * @return The userid.
   */
  @java.lang.Override
  public int getUserid() {
    return userid_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (wpid_ != 0) {
      output.writeInt32(1, wpid_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(wpname_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, wpname_);
    }
    if (timegoal_ != 0) {
      output.writeInt32(3, timegoal_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(type_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, type_);
    }
    if (userid_ != 0) {
      output.writeInt32(5, userid_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (wpid_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, wpid_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(wpname_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, wpname_);
    }
    if (timegoal_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, timegoal_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(type_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, type_);
    }
    if (userid_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, userid_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof resep3.javat3.protobuf.WPData)) {
      return super.equals(obj);
    }
    resep3.javat3.protobuf.WPData other = (resep3.javat3.protobuf.WPData) obj;

    if (getWpid()
        != other.getWpid()) return false;
    if (!getWpname()
        .equals(other.getWpname())) return false;
    if (getTimegoal()
        != other.getTimegoal()) return false;
    if (!getType()
        .equals(other.getType())) return false;
    if (getUserid()
        != other.getUserid()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + WPID_FIELD_NUMBER;
    hash = (53 * hash) + getWpid();
    hash = (37 * hash) + WPNAME_FIELD_NUMBER;
    hash = (53 * hash) + getWpname().hashCode();
    hash = (37 * hash) + TIMEGOAL_FIELD_NUMBER;
    hash = (53 * hash) + getTimegoal();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + getUserid();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static resep3.javat3.protobuf.WPData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static resep3.javat3.protobuf.WPData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static resep3.javat3.protobuf.WPData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static resep3.javat3.protobuf.WPData parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(resep3.javat3.protobuf.WPData prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code WPData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:WPData)
      resep3.javat3.protobuf.WPDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return resep3.javat3.protobuf.WorkoutPlan.internal_static_WPData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return resep3.javat3.protobuf.WorkoutPlan.internal_static_WPData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              resep3.javat3.protobuf.WPData.class, resep3.javat3.protobuf.WPData.Builder.class);
    }

    // Construct using resep3.javat3.protobuf.WPData.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      wpid_ = 0;

      wpname_ = "";

      timegoal_ = 0;

      type_ = "";

      userid_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return resep3.javat3.protobuf.WorkoutPlan.internal_static_WPData_descriptor;
    }

    @java.lang.Override
    public resep3.javat3.protobuf.WPData getDefaultInstanceForType() {
      return resep3.javat3.protobuf.WPData.getDefaultInstance();
    }

    @java.lang.Override
    public resep3.javat3.protobuf.WPData build() {
      resep3.javat3.protobuf.WPData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public resep3.javat3.protobuf.WPData buildPartial() {
      resep3.javat3.protobuf.WPData result = new resep3.javat3.protobuf.WPData(this);
      result.wpid_ = wpid_;
      result.wpname_ = wpname_;
      result.timegoal_ = timegoal_;
      result.type_ = type_;
      result.userid_ = userid_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof resep3.javat3.protobuf.WPData) {
        return mergeFrom((resep3.javat3.protobuf.WPData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(resep3.javat3.protobuf.WPData other) {
      if (other == resep3.javat3.protobuf.WPData.getDefaultInstance()) return this;
      if (other.getWpid() != 0) {
        setWpid(other.getWpid());
      }
      if (!other.getWpname().isEmpty()) {
        wpname_ = other.wpname_;
        onChanged();
      }
      if (other.getTimegoal() != 0) {
        setTimegoal(other.getTimegoal());
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
        onChanged();
      }
      if (other.getUserid() != 0) {
        setUserid(other.getUserid());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      resep3.javat3.protobuf.WPData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (resep3.javat3.protobuf.WPData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int wpid_ ;
    /**
     * <code>int32 wpid = 1;</code>
     * @return The wpid.
     */
    @java.lang.Override
    public int getWpid() {
      return wpid_;
    }
    /**
     * <code>int32 wpid = 1;</code>
     * @param value The wpid to set.
     * @return This builder for chaining.
     */
    public Builder setWpid(int value) {
      
      wpid_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 wpid = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearWpid() {
      
      wpid_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object wpname_ = "";
    /**
     * <code>string wpname = 2;</code>
     * @return The wpname.
     */
    public java.lang.String getWpname() {
      java.lang.Object ref = wpname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        wpname_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string wpname = 2;</code>
     * @return The bytes for wpname.
     */
    public com.google.protobuf.ByteString
        getWpnameBytes() {
      java.lang.Object ref = wpname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        wpname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string wpname = 2;</code>
     * @param value The wpname to set.
     * @return This builder for chaining.
     */
    public Builder setWpname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      wpname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string wpname = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearWpname() {
      
      wpname_ = getDefaultInstance().getWpname();
      onChanged();
      return this;
    }
    /**
     * <code>string wpname = 2;</code>
     * @param value The bytes for wpname to set.
     * @return This builder for chaining.
     */
    public Builder setWpnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      wpname_ = value;
      onChanged();
      return this;
    }

    private int timegoal_ ;
    /**
     * <code>int32 timegoal = 3;</code>
     * @return The timegoal.
     */
    @java.lang.Override
    public int getTimegoal() {
      return timegoal_;
    }
    /**
     * <code>int32 timegoal = 3;</code>
     * @param value The timegoal to set.
     * @return This builder for chaining.
     */
    public Builder setTimegoal(int value) {
      
      timegoal_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 timegoal = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearTimegoal() {
      
      timegoal_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object type_ = "";
    /**
     * <code>string type = 4;</code>
     * @return The type.
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string type = 4;</code>
     * @return The bytes for type.
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string type = 4;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string type = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      
      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <code>string type = 4;</code>
     * @param value The bytes for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      type_ = value;
      onChanged();
      return this;
    }

    private int userid_ ;
    /**
     * <code>int32 userid = 5;</code>
     * @return The userid.
     */
    @java.lang.Override
    public int getUserid() {
      return userid_;
    }
    /**
     * <code>int32 userid = 5;</code>
     * @param value The userid to set.
     * @return This builder for chaining.
     */
    public Builder setUserid(int value) {
      
      userid_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 userid = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserid() {
      
      userid_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:WPData)
  }

  // @@protoc_insertion_point(class_scope:WPData)
  private static final resep3.javat3.protobuf.WPData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new resep3.javat3.protobuf.WPData();
  }

  public static resep3.javat3.protobuf.WPData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WPData>
      PARSER = new com.google.protobuf.AbstractParser<WPData>() {
    @java.lang.Override
    public WPData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WPData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WPData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WPData> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public resep3.javat3.protobuf.WPData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

