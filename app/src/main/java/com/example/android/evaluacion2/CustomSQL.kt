package com.example.android.evaluacion2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.sql.SQLException

class CustomSQL(val context: Context,
                val name: String,
                val factory: SQLiteDatabase.CursorFactory?,
                var version: Int): SQLiteOpenHelper(context,name,factory,version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE Product(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT" +
                "stock INTEGER" +
                "price TEXT" +
                "category TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
     }

    fun addProduct(product: Product){
        try {
            val db = this.writableDatabase
            //otra forma mas de crear elemento clave valor
            var cv = ContentValues()
            //debe llamarse igual que la columna de la tabla creada
            cv.put("name", product.name)
            cv.put("stock", product.stock)
            cv.put("price", product.price)
            cv.put("category", product.category)

            val resultado = db.insert("Product",null,cv)
            db.close()
            if (resultado !=-1L){
                Toast.makeText(context,"Producto no agregado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Producto agregado", Toast.LENGTH_SHORT).show()
            }

        }catch (e: SQLException){
            Toast.makeText(context,"Error al insertar ${e.message}", Toast.LENGTH_SHORT).show()
            Log.e("sqlListar", e.message)
        }
    }


    fun listar(): ArrayList<Product> {
        var lista = ArrayList<Product>()
        try {
            val db = this.writableDatabase
            var cursor: Cursor? = null
            cursor = db.rawQuery("select * from Product", null)
            if (cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(0)
                    val nameProduct = cursor.getString(1)
                    val stock = cursor.getInt(2)
                    val price = cursor.getDouble(3)
                    val category = cursor.getString(4)


                    val product = Product(id, nameProduct, stock, price, category)
                    lista.add(product)
                } while (cursor.moveToNext())

            }
            db.close()
            return lista
        } catch (e: SQLException) {
            Toast.makeText(context, "Error al listar ${e.message}", Toast.LENGTH_SHORT).show()
        }
        return lista

    }


}