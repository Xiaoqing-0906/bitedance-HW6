package com.app.keepdog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rv)
        val decoration =
            DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL)
        val drawable = ContextCompat.getDrawable(this, R.drawable.shape_question_diveder)
        decoration.setDrawable(drawable!!)
        rv.addItemDecoration(decoration)
        rv.layoutManager = LinearLayoutManager(this)
        val list: MutableList<DogItem> = ArrayList()
        list.add(
                DogItem(
                        R.mipmap.myq, "Snow",
                        "边境牧羊犬又名边境柯利犬，是一种非常聪明的犬种，主要分布在四个国家——英国、美国、澳大利亚和新西兰。美国科学家通过大量测试研究发现，边境牧羊犬的服从智商超过德国牧羊犬和贵妇犬，在一百多个犬种中排名第一。最早时期苏格兰被放牧的羊以及用来看管羊的犬都是在苏格兰群岛上发现的，那些犬都是来源于以前从爱尔兰移居到苏格兰的教士，他们带过去的犬，并且是在早期维京人还没入侵苏格兰之前就已经过去了的。可是在这种崎岖的地理环境内人们也就只有依靠犬来帮忙集合、驱赶以及看牧牲畜了。根据现代牧羊犬的起源，它们有着“眼神控制”这样的能力，这种能力是通过在英格兰和苏格兰边境地方的牧羊人发展并且训练出来的，所以人们把这种犬就称做“边境牧羊犬”。"
                )
        )
        list.add(
                DogItem(
                        R.mipmap.gbq, "Night",
                        "贵宾犬在法国被视为国犬，很多人认为贵宾犬原产于法国，但许多国家仍对贵宾犬的起源争执不休，都想把它据为己有。德国、前苏联、意大利等国均各抒己见，认为有些品种的贵宾犬产于他们的国家，如白毛品种以法国居多，棕毛品种多产于德国，黑毛品种以前苏联为多，茶褐色品种则以意大利为多。有些史学家深信，德国、前苏联、法国在贵宾犬的发展过程中，均扮演过极其重要的角色 [1]  。贵宾犬起源于欧洲，具体是哪个国家还有争议。贵宾犬以水中捕猎而著称，是水猎犬。但是只有标准贵宾具有工作能力。它是聪明而善解人意的犬种。多年以来，它一直被认为是法国的国犬。贵宾犬根据体型大小被AKC标准分为标准型，迷你型，玩具型三种。而FCI把它们分为大型，中型，迷你型，玩具型四种。贵宾犬气质独特，造型多变，赢得了许多人的欢心，给人一种漂亮的、聪明的印象。值得注意的是，并没有泰迪这个品种的犬，泰迪不是犬种，它只是贵宾犬众多美容造型中的一种的名称。"
                )
        )
        //list.add(new DogItem(R.mipmap.chaiq,"Watchman","原产于日本，是一种古老的品种，经长期豢养培育，养成忠实、服从、忍耐的天性。柴犬的警觉性高，平时习惯警觉地站在高处向下观望，个性机敏、独立，身体强健，动作敏捷，色泽如木柴，以前主要是被人类训练用来猎捕小动物，曾是穿梭于深山林间的狩猎好手，故称之为柴犬。柴犬外观和日本秋田犬比较好像是它的缩小版。在日本，柴犬被政府指定为“天然纪念物” [3]  。"));
        //list.add(new DogItem(R.mipmap.taidi,"Baby","贵宾犬在法国被视为国犬，很多人认为贵宾犬原产于法国，但许多国家仍对贵宾犬的起源争执不休，都想把它据为己有。德国、前苏联、意大利等国均各抒己见，认为有些品种的贵宾犬产于他们的国家，如白毛品种以法国居多，棕毛品种多产于德国，黑毛品种以前苏联为多，茶褐色品种则以意大利为多。有些史学家深信，德国、前苏联、法国在贵宾犬的发展过程中，均扮演过极其重要的角色 [1]  。贵宾犬起源于欧洲，具体是哪个国家还有争议。贵宾犬以水中捕猎而著称，是水猎犬。但是只有标准贵宾具有工作能力。它是聪明而善解人意的犬种。多年以来，它一直被认为是法国的国犬。贵宾犬根据体型大小被AKC标准分为标准型，迷你型，玩具型三种。而FCI把它们分为大型，中型，迷你型，玩具型四种。贵宾犬气质独特，造型多变，赢得了许多人的欢心，给人一种漂亮的、聪明的印象。值得注意的是，并没有泰迪这个品种的犬，泰迪不是犬种，它只是贵宾犬众多美容造型中的一种的名称。"));
        //list.add(new DogItem(R.mipmap.myq,"Snow","边境牧羊犬又名边境柯利犬，是一种非常聪明的犬种，主要分布在四个国家——英国、美国、澳大利亚和新西兰。美国科学家通过大量测试研究发现，边境牧羊犬的服从智商超过德国牧羊犬和贵妇犬，在一百多个犬种中排名第一。最早时期苏格兰被放牧的羊以及用来看管羊的犬都是在苏格兰群岛上发现的，那些犬都是来源于以前从爱尔兰移居到苏格兰的教士，他们带过去的犬，并且是在早期维京人还没入侵苏格兰之前就已经过去了的。可是在这种崎岖的地理环境内人们也就只有依靠犬来帮忙集合、驱赶以及看牧牲畜了。根据现代牧羊犬的起源，它们有着“眼神控制”这样的能力，这种能力是通过在英格兰和苏格兰边境地方的牧羊人发展并且训练出来的，所以人们把这种犬就称做“边境牧羊犬”。"));
        //list.add(new DogItem(R.mipmap.gbq,"Night","贵宾犬在法国被视为国犬，很多人认为贵宾犬原产于法国，但许多国家仍对贵宾犬的起源争执不休，都想把它据为己有。德国、前苏联、意大利等国均各抒己见，认为有些品种的贵宾犬产于他们的国家，如白毛品种以法国居多，棕毛品种多产于德国，黑毛品种以前苏联为多，茶褐色品种则以意大利为多。有些史学家深信，德国、前苏联、法国在贵宾犬的发展过程中，均扮演过极其重要的角色 [1]  。贵宾犬起源于欧洲，具体是哪个国家还有争议。贵宾犬以水中捕猎而著称，是水猎犬。但是只有标准贵宾具有工作能力。它是聪明而善解人意的犬种。多年以来，它一直被认为是法国的国犬。贵宾犬根据体型大小被AKC标准分为标准型，迷你型，玩具型三种。而FCI把它们分为大型，中型，迷你型，玩具型四种。贵宾犬气质独特，造型多变，赢得了许多人的欢心，给人一种漂亮的、聪明的印象。值得注意的是，并没有泰迪这个品种的犬，泰迪不是犬种，它只是贵宾犬众多美容造型中的一种的名称。"));
        //list.add(new DogItem(R.mipmap.chaiq,"Watchman","原产于日本，是一种古老的品种，经长期豢养培育，养成忠实、服从、忍耐的天性。柴犬的警觉性高，平时习惯警觉地站在高处向下观望，个性机敏、独立，身体强健，动作敏捷，色泽如木柴，以前主要是被人类训练用来猎捕小动物，曾是穿梭于深山林间的狩猎好手，故称之为柴犬。柴犬外观和日本秋田犬比较好像是它的缩小版。在日本，柴犬被政府指定为“天然纪念物” [3]  。"));
        //list.add(new DogItem(R.mipmap.taidi,"Baby","贵宾犬在法国被视为国犬，很多人认为贵宾犬原产于法国，但许多国家仍对贵宾犬的起源争执不休，都想把它据为己有。德国、前苏联、意大利等国均各抒己见，认为有些品种的贵宾犬产于他们的国家，如白毛品种以法国居多，棕毛品种多产于德国，黑毛品种以前苏联为多，茶褐色品种则以意大利为多。有些史学家深信，德国、前苏联、法国在贵宾犬的发展过程中，均扮演过极其重要的角色 [1]  。贵宾犬起源于欧洲，具体是哪个国家还有争议。贵宾犬以水中捕猎而著称，是水猎犬。但是只有标准贵宾具有工作能力。它是聪明而善解人意的犬种。多年以来，它一直被认为是法国的国犬。贵宾犬根据体型大小被AKC标准分为标准型，迷你型，玩具型三种。而FCI把它们分为大型，中型，迷你型，玩具型四种。贵宾犬气质独特，造型多变，赢得了许多人的欢心，给人一种漂亮的、聪明的印象。值得注意的是，并没有泰迪这个品种的犬，泰迪不是犬种，它只是贵宾犬众多美容造型中的一种的名称。"));
        val adapter = MainAdapter(this, list)
        adapter.setListener(object : MainAdapter.MyOnClickListener {
            override fun onClick(position: Int) {
                DeatilActivity.openWebviewActivity(this@MainActivity, list[position])
            }
        })
        rv.adapter = adapter
    }
}