package com.example.myflexiblefragment

import android.accounts.AuthenticatorDescription
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.security.identity.AccessControlProfile
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_detail_category.*

class DetailCategoryFragment : Fragment(), View.OnClickListener {

    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var btnProfile: Button
    lateinit var btnShowDialog: Button
    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener(this)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
        btnShowDialog.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val decsFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = decsFromBundle
        }
        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            tv_category_name.text = description
        }



    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_profile ->{
                    val mIntent = Intent(activity, ProfileActivity::class.java)
                    startActivity(mIntent)
                }

                R.id.btn_show_dialog -> {
                    val mOptionDialogFragment = OptionDialogFragment()

                    val mFragmentManager = childFragmentManager
                    mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment::class.java.simpleName)

                }
            }
        }
    }
}
