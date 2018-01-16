package tango.sudao.com.kotlintest

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * Created by pcdalao on 2018/1/6.
 */
 class TabEntity(var title:String,var data1:Int,var data2:Int) :CustomTabEntity {
    override fun getTabSelectedIcon(): Int {
        return data1
    }

    override fun getTabTitle(): String {
        return  title
    }

    override fun getTabUnselectedIcon(): Int {
        return data2
    }


}