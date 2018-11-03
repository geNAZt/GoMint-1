/*
 * Copyright (c) 2018 GoMint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.config.converter;


import io.gomint.config.InternalConverter;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;

/**
 * @author geNAZt
 * @version 1.0
 */
public class PrimitiveConverter implements Converter {

    private HashSet<String> types = new HashSet<String>() {{
        this.add( "boolean" );
        this.add( "char" );
        this.add( "byte" );
        this.add( "short" );
        this.add( "int" );
        this.add( "long" );
        this.add( "float" );
        this.add( "double" );
    }};

    // This constructor is needed to prevent InternalConverter throwing an exception
    // InternalConverter accesses this constructor with Reflection to create an instance
    // !!!! DO NOT REMOVE !!!!
    // It will compile but will fail at runtime
    public PrimitiveConverter( InternalConverter internalConverter ) {

    }

    @Override
    public Object toConfig( Class<?> type, Object object, ParameterizedType parameterizedType ) {
        return object;
    }

    @Override
    public Object fromConfig( Class type, Object object, ParameterizedType parameterizedType ) {
        switch ( type.getSimpleName() ) {
            case "short":
                return ( object instanceof Short ) ? object : new Integer( (int) object ).shortValue();
            case "byte":
                return ( object instanceof Byte ) ? object : new Integer( (int) object ).byteValue();
            case "float":
                if ( object instanceof Integer ) {
                    return new Double( (int) object ).floatValue();
                }

                return ( object instanceof Float ) ? object : new Double( (double) object ).floatValue();
            case "char":
                return ( object instanceof Character ) ? object : ( (String) object ).charAt( 0 );
            default:
                return object;
        }
    }

    @Override
    public boolean supports( Class<?> type ) {
        return types.contains( type.getName() );
    }

}
