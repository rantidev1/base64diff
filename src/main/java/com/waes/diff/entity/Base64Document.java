/*******************************************************************************
 * Copyright 2020 rantidev.singh1@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.waes.diff.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Column;

/**
 * The Class Base64Document.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@Entity
public class Base64Document {

    /** The id. */
    @Id
    private long id;

    /** The left. */
    @Lob
    @Column(length = 32000)
    private String left;

    /** The right. */
    @Lob
    @Column(length = 32000)
    private String right;

    /**
     * Instantiates a new base 64 document.
     */
    public Base64Document() {

    }

    /**
     * This constructor creates new object instances for validation and persistence.
     * 
     * @param id    of the object. It must to be informed. It is not auto-generated.
     * @param left  side of data is being sent through the request.
     * @param right side of data is being sent through the request.
     */
    public Base64Document(long id, String left, String right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the left.
     *
     * @return the left
     */
    public String getLeft() {
        return left;
    }

    /**
     * Sets the left.
     *
     * @param left the new left
     */
    public void setLeft(String left) {
        this.left = left;
    }

    /**
     * Gets the right.
     *
     * @return the right
     */
    public String getRight() {
        return right;
    }

    /**
     * Sets the right.
     *
     * @param right the new right
     */
    public void setRight(String right) {
        this.right = right;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Base64Document other = (Base64Document) obj;
        if (id != other.id)
            return false;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Document [id=" + getId() + ", left=" + getLeft() + ", right=" + getRight() + "]";
    }
}
