/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package YoutubeDataModels;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class HealthCheckModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8742833814557903542L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"HealthCheckModel\",\"namespace\":\"avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"id of youtube channel\"},{\"name\":\"title\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"youtube channel title\"},{\"name\":\"viewCount\",\"type\":\"long\",\"doc\":\"number of views\"}],\"doc:\":\"A basic schema for to store some youtube channel info for health check\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** id of youtube channel */
   private java.lang.String id;
  /** youtube channel title */
   private java.lang.String title;
  /** number of views */
   private long viewCount;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public HealthCheckModel() {}

  /**
   * All-args constructor.
   * @param id id of youtube channel
   * @param title youtube channel title
   * @param viewCount number of views
   */
  public HealthCheckModel(java.lang.String id, java.lang.String title, java.lang.Long viewCount) {
    this.id = id;
    this.title = title;
    this.viewCount = viewCount;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return title;
    case 2: return viewCount;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.String)value$; break;
    case 1: title = (java.lang.String)value$; break;
    case 2: viewCount = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return id of youtube channel
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Gets the value of the 'title' field.
   * @return youtube channel title
   */
  public java.lang.String getTitle() {
    return title;
  }


  /**
   * Gets the value of the 'viewCount' field.
   * @return number of views
   */
  public java.lang.Long getViewCount() {
    return viewCount;
  }


  /**
   * Creates a new HealthCheckModel RecordBuilder.
   * @return A new HealthCheckModel RecordBuilder
   */
  public static YoutubeDataModels.HealthCheckModel.Builder newBuilder() {
    return new YoutubeDataModels.HealthCheckModel.Builder();
  }

  /**
   * Creates a new HealthCheckModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new HealthCheckModel RecordBuilder
   */
  public static YoutubeDataModels.HealthCheckModel.Builder newBuilder(YoutubeDataModels.HealthCheckModel.Builder other) {
    return new YoutubeDataModels.HealthCheckModel.Builder(other);
  }

  /**
   * Creates a new HealthCheckModel RecordBuilder by copying an existing HealthCheckModel instance.
   * @param other The existing instance to copy.
   * @return A new HealthCheckModel RecordBuilder
   */
  public static YoutubeDataModels.HealthCheckModel.Builder newBuilder(YoutubeDataModels.HealthCheckModel other) {
    return new YoutubeDataModels.HealthCheckModel.Builder(other);
  }

  /**
   * RecordBuilder for HealthCheckModel instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<HealthCheckModel>
    implements org.apache.avro.data.RecordBuilder<HealthCheckModel> {

    /** id of youtube channel */
    private java.lang.String id;
    /** youtube channel title */
    private java.lang.String title;
    /** number of views */
    private long viewCount;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(YoutubeDataModels.HealthCheckModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.title)) {
        this.title = data().deepCopy(fields()[1].schema(), other.title);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.viewCount)) {
        this.viewCount = data().deepCopy(fields()[2].schema(), other.viewCount);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing HealthCheckModel instance
     * @param other The existing instance to copy.
     */
    private Builder(YoutubeDataModels.HealthCheckModel other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.title)) {
        this.title = data().deepCopy(fields()[1].schema(), other.title);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.viewCount)) {
        this.viewCount = data().deepCopy(fields()[2].schema(), other.viewCount);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * id of youtube channel
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * id of youtube channel
      * @param value The value of 'id'.
      * @return This builder.
      */
    public YoutubeDataModels.HealthCheckModel.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * id of youtube channel
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * id of youtube channel
      * @return This builder.
      */
    public YoutubeDataModels.HealthCheckModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'title' field.
      * youtube channel title
      * @return The value.
      */
    public java.lang.String getTitle() {
      return title;
    }

    /**
      * Sets the value of the 'title' field.
      * youtube channel title
      * @param value The value of 'title'.
      * @return This builder.
      */
    public YoutubeDataModels.HealthCheckModel.Builder setTitle(java.lang.String value) {
      validate(fields()[1], value);
      this.title = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * youtube channel title
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'title' field.
      * youtube channel title
      * @return This builder.
      */
    public YoutubeDataModels.HealthCheckModel.Builder clearTitle() {
      title = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'viewCount' field.
      * number of views
      * @return The value.
      */
    public java.lang.Long getViewCount() {
      return viewCount;
    }

    /**
      * Sets the value of the 'viewCount' field.
      * number of views
      * @param value The value of 'viewCount'.
      * @return This builder.
      */
    public YoutubeDataModels.HealthCheckModel.Builder setViewCount(long value) {
      validate(fields()[2], value);
      this.viewCount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'viewCount' field has been set.
      * number of views
      * @return True if the 'viewCount' field has been set, false otherwise.
      */
    public boolean hasViewCount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'viewCount' field.
      * number of views
      * @return This builder.
      */
    public YoutubeDataModels.HealthCheckModel.Builder clearViewCount() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public HealthCheckModel build() {
      try {
        HealthCheckModel record = new HealthCheckModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.title = fieldSetFlags()[1] ? this.title : (java.lang.String) defaultValue(fields()[1]);
        record.viewCount = fieldSetFlags()[2] ? this.viewCount : (java.lang.Long) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
