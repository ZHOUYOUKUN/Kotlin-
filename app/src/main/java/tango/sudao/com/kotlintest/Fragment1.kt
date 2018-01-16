package tango.sudao.com.kotlintest

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwang.smartrefresh.header.MaterialHeader
import kotlinx.android.synthetic.main.layout.*
import kotlin.collections.ArrayList

/**
 * Created by pcdalao on 2018/1/6.
 */
class Fragment1(): Fragment() {

    private var mMaterialHeader:MaterialHeader?=null;

    private var mcontext:Context?=null

    private var lists=ArrayList<String>()

    private var adapter:HomeAdapter?=null;
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mcontext=context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.layout,container,false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init();
    }

    public fun init(){

        //内容跟随偏移
        refreshLayout?.setEnableHeaderTranslationContent(true)
        refreshLayout?.setOnRefreshListener {
            //下拉刷新网络请求
            requestHomeData()
            Log.d("111111111111111","111111111111111111111111111")

        }
        refreshLayout?.setOnLoadmoreListener {
            Log.d("111111111111111","111111111111111111111111111")
            requestMore();
        }
       // var mheader=MaterialHeader(activity).setShowBezierWave(true)
       // refreshLayout.setRefreshHeader(mheader);
        //设置 Footer 为 球脉冲
        //refreshLayout.setRefreshFooter(BallPulseFooter(activity).setSpinnerStyle(SpinnerStyle.Scale));

        //mMaterialHeader = mRefreshLayout?.refreshHeader as MaterialHeader?
        //打开下拉刷新区域块背景:
        //mMaterialHeader?.setShowBezierWave(true)
        //设置下拉刷新主题颜色
        // mRefreshLayout?.setPrimaryColorsId(R.color.color_light_black, R.color.color_title_bg)

        for (i in 0 until 100){
            lists?.add("这是第"+i+"条数据")
        }

        //recyclerview.layoutManager=LinearLayoutManager(activity)
        recyclerview.layoutManager = LinearLayoutManager(activity)

        adapter=HomeAdapter(lists,activity)
        recyclerview.adapter=adapter


    }
    private fun requestHomeData(){
        Thread(Runnable {

            kotlin.run {
                Thread.sleep(3000)
                var m=Message()
                m.what=1
                hander.sendMessage(m)
            }
        }).start()
    }
    private fun requestMore(){
        Thread(Runnable {

            kotlin.run {
                Thread.sleep(3000)
                var m=Message();
                m.what=2;
                hander.sendMessage(m);
            }
        }).start()
    }

    private var hander:Handler=object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if(msg?.what==1){
                refreshLayout.finishRefresh();
            }
            if(msg?.what==2){
                refreshLayout.finishLoadmore()
                for (i in 100 until 200){
                    lists?.add("这是第"+i+"条数据")
                }
                recyclerview.adapter.notifyItemRangeChanged(100,200)

            }

        }
    }
}