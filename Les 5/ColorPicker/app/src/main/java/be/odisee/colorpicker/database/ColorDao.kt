package be.odisee.colorpicker.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ColorDao {

    @Query("SELECT * FROM colors")
    suspend fun getAll(): Array<Color>

    @Query("SELECT * FROM colors")
    fun getAllLiveData(): LiveData<Array<Color>>

    @Query("SELECT * FROM colors WHERE id = :id")
    fun getColor(id: Long): LiveData<Color>

    @Insert
    suspend fun insert(color: Color)

    @Update
    suspend fun update(color: Color)

    @Delete
    suspend fun delete(color: Color)
}