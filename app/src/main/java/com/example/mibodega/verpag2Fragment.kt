package com.example.mibodega

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mibodega.databinding.FragmentVerpag2Binding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator

class verpag2Fragment : Fragment() {
    private var _binding : FragmentVerpag2Binding? = null
    private val binding get()=_binding!!
    val args: verpag2FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentVerpag2Binding.inflate(inflater,container,false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nombre=args.nombre

        binding.vp2Credit.adapter=NoticiaAdaptador(this,nombre)
        TabLayoutMediator(binding.TabMenu,binding.vp2Credit){
                tab, position ->
            when(position){
                1->{
                    tab.text="Menu inicio"
                    tab.setIcon(R.drawable.ic_home)
                    /*val badge : BadgeDrawable =tab.orCreateBadge
                    badge.backgroundColor = ContextCompat.getColor(requireContext().applicationContext, R.color.black)
                    badge.number=117
                    badge.maxCharacterCount=3
                    badge.badgeGravity= BadgeDrawable.TOP_START */
                }
                0->{
                    tab.text="Creditos"
                    tab.setIcon(R.drawable.ic_credit)
                }
            }
        }.attach()
    }
}

class NoticiaAdaptador(fragment: Fragment, private val nombre:String) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int =2
    //Es lo mismo que: return 2

    override fun createFragment(position: Int): Fragment {
        val fragment = if(position==1)
            MenuFragment().apply {
                arguments=Bundle().apply {
                    putString("nombre",nombre)
                }
            }
        else
            CreditFragment().apply {
                arguments=Bundle().apply {
                    putString("nombre",nombre)
                }
            }
        return fragment
    }

}