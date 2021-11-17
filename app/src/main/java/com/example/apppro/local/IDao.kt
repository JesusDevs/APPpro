package com.example.apppro.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.apppro.pojo.ContactsReponseItem
import com.example.apppro.pojo.FeedResponseItem
@Dao
interface IDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFeed(list: List<FeedResponseItem>)

    @Query("SELECT * FROM feed_table ")
   fun getAllFeedDataBase(): LiveData<List<FeedResponseItem>>

    @Query("SELECT * FROM contacts_table")
    fun getAllFeeCoDataBases(): LiveData<List<ContactsReponseItem>>


   /* @Query("SELECT * FROM feed_table WHERE authorId = authorId")
   fun getFeedByAutorID(autorId: String): LiveData<FeedResponseItem>
*/
}