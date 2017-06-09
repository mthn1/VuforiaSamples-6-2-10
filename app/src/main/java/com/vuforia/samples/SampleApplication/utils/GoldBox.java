/*===============================================================================
Copyright (c) 2016 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other
countries.
===============================================================================*/

package com.vuforia.samples.SampleApplication.utils;

import java.nio.Buffer;


public class GoldBox extends MeshObject
{

    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;


    public GoldBox()
    {
        setVerts();
        setTexCoords();
        setNorms();
        setIndices();
    }


    private void setVerts()
    {
        double[] GoldBox_VERTS = {
                 10.000000, -1.000000, -1.000000,
                 10.000000, -1.000000, 1.000000,
                 -10.000000, -1.000000, 1.000000,
                 -10.000000, -1.000000, -1.000000,
                 10.000000, 1.000000, -10.000000,
                 10.000000, 10.000000, 10.000000,
                 -10.000000, 10.000000, 10.000000,
                 -10.000000, 10.000000, -10.000000
        };
        mVertBuff = fillBuffer(GoldBox_VERTS);
        verticesNumber = GoldBox_VERTS.length / 3;
    }


    private void setTexCoords()
    {
        double[] GoldBox_TEX_COORDS = {
                 0.500001, 0.499999,
                 0.500001, 0.250043,
                 0.749957, 0.250043,
                 0.749957, 0.499999,
                 0.250045, 0.500000,
                 0.000087, 0.500000,
                 0.000087, 0.250042,
                 0.250044, 0.250043,
                 0.500001, 0.000087,
                 0.749957, 0.000087,
                 0.999913, 0.250043,
                 0.999913, 0.499999,
                 0.500001, 0.749955,
                 0.749957, 0.749955
        };
        mTexCoordBuff = fillBuffer(GoldBox_TEX_COORDS);

    }


    private void setNorms()
    {
        double[] GoldBox_NORMS = {  };
        mNormBuff = fillBuffer(GoldBox_NORMS);
    }


    private void setIndices()
    {
        short[] GoldBox_INDICES = {
             1, 2, 3, 4,
             5, 8, 7, 6,
             1, 5, 6, 2,
             2, 6, 7, 3,
             3, 7, 8, 4,
             5, 1, 4, 8
        };
        mIndBuff = fillBuffer(GoldBox_INDICES);
        indicesNumber = GoldBox_INDICES.length;
    }


    public int getNumObjectIndex()
    {
        return indicesNumber;
    }


    @Override
    public int getNumObjectVertex()
    {
        return verticesNumber;
    }


    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType)
    {
        Buffer result = null;
        switch (bufferType)
        {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
                break;
            case BUFFER_TYPE_INDICES:
                result = mIndBuff;
            default:
                break;

        }

        return result;
    }

}
