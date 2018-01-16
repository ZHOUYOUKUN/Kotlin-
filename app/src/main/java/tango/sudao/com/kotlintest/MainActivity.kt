package tango.sudao.com.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.flyco.tablayout.listener.CustomTabEntity
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val mTitles = arrayOf("预约", "联系人", "我的")

    private val data1= intArrayOf(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher)

    private val data2= intArrayOf(R.mipmap.ilauncher,R.mipmap.ilauncher,R.mipmap.ilauncher)

    private var mTabEntities = ArrayList<CustomTabEntity>()

    private var mImmersionBar: ImmersionBar? = null

    private var mHomeFragment:Fragment1?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)


        mImmersionBar = ImmersionBar.with(this)
                .transparentStatusBar() //透明状态栏，



        mImmersionBar?.init()  //必须调用方可沉浸式


        initTab()
    }

    private fun initTab(){
        (0 until mTitles.size).mapTo(mTabEntities){ TabEntity(mTitles[it], data1[it], data2[it])}

        tab_layout.setTabData(mTabEntities)

        SwitchF(0)
    }
        fun SwitchF(index:Int){
            val transaction = supportFragmentManager.beginTransaction()
             if (mHomeFragment == null) {
                mHomeFragment = Fragment1()
                transaction.add(R.id.fl_container, mHomeFragment, "home")
            }
            transaction.commitAllowingStateLoss()
        }

}
