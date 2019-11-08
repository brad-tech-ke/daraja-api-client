package brad.tech.web.safaricom.daraja;

import java.io.Serializable;

/**
 * This provides an interface for representing json as a string.
 * <p>
 * You can use a separate library for the same.
 */
public interface JsonSerializable extends Serializable {

    /**
     * This provides a json string of the serializable object.
     *
     * @return a json string representation
     */
    String toJson();
}
