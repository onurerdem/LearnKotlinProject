package com.onurerdem.learnkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.onurerdem.learnkotlinproject.adapter.MessageListAdapter
import com.onurerdem.learnkotlinproject.databinding.ActivityMainBinding
import com.onurerdem.learnkotlinproject.model.MessageItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var messageListAdapter = MessageListAdapter()
    private var messageList: ArrayList<MessageItem> = arrayListOf()

    var dump = LogDumpGetUnique().replace(",","\n")
    var dump2 = dump.replace(";","\n")
    var tempId = ""
    var tempName = ""
    var tempUserName = ""
    var tempEMail = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrSplit: List<String> = dump2.split("\n")
        for (i in arrSplit) {
            if(i.contains("id=")){
                tempId += i
            }
            if(i.contains("id=") == false && i.contains("username=") == false && i.contains("email=") == false){
                tempName += i
            }
            if(i.contains("username=")){
                tempUserName += i
            }
            if(i.contains("email=")){
                tempEMail += i
            }
        }
        var temp1 = tempId.trim()
        var temp2 = tempName.trim()
        var temp3 = tempUserName.trim()
        var temp4 = tempEMail.trim()
        var tempListId = temp1.split(" ").toTypedArray()
        var tempListName = temp2.split("name=").toTypedArray()
        var tempListUserName = temp3.split("username=").toTypedArray()
        var tempListEMail = temp4.split("email=").toTypedArray()

        for (l in 0..tempListId.size - 1){
            messageList.add(MessageItem(name = tempListName.get(l + 1).trim(),message = tempListUserName.get(l + 1).trim() + "\n" + tempListEMail.get(l +1).trim(), id = tempListId.get(l).substring(3,tempListId.get(l).length)))
        }

        binding.apply {
            rvMessagelist.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            rvMessagelist.adapter = messageListAdapter

            messageListAdapter.listeyiDoldur(messageList)
        }
    }
    fun LogDumpGetUnique(): String {
        var log_dump: String = "name=John Trust, username=john3, email=john3@gmail.com, id=434453; name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; name=Robert M, username=rm44, id=222342, email=rm@me.com; name=Robert M, username=rm4411, id=5535, email=rm@me.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"
        return log_dump;
    }
}