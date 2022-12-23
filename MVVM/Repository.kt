package com.example.androidstudioclass.MVVM

import androidx.lifecycle.MutableLiveData

class Repository {
    val database = Firebase.database
    val dbRef = database.getReference("")
    fun observeObjectList(arrObject: MutableLiveData<ArrayList<Object>>){

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val arr=ArrayList<Object>()

                for(snap in snapshot.children){

                    val obj : Object?= snap.getValue<Object>()
                    obj?.let{
                        arr.add(it)

                    }


                }
                arrObject.postValue(arr)



            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        )
    }

    fun postObject(obj : Object){

    }

}
