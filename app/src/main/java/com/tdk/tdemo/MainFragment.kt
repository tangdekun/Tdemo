package  com.tdk.tdemo

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @Author koridy
 * @Date 2019/1/8-22:17
 * @Email tangdekun0924@gmail.com
 */
class MainFragment : Fragment(){



    companion object {
        private const val TAG = "MainFragment"
        fun newMainFragment(): MainFragment = MainFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    interface FragmentListener {
        fun process(name: String)
    }

    var fragmentListener: FragmentListener? = null
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
        if (isAdded) {
            Log.d(TAG, "${arguments?.getString("key")}")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        if (isAdded) {
            tv.text = arguments?.getString("key")

        }
        bt.setOnClickListener{
            fragmentListener?.process("OK")
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainActivity) {
            context.gettitle()
            fragmentListener = context
            Log.d(TAG, "title:${context.gettitle()}")
        }

    }


    override fun onDetach() {
        super.onDetach()
        /**
        在onDetach解除对Activity的引用，防止Activity泄露
         */
        fragmentListener = null
    }


}