package com.example.a220315_sampleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    public MyButton(@NonNull Context context) { //생성자
        super(context);

        init(context); //초기값 설정
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) { //생성자
        super(context, attrs);

        init(context); //초기값 설정
    }

    private void init(Context context){
        setBackgroundColor(Color.CYAN); //배경색 지정
        setTextColor(Color.BLACK); //글자색 지정

        float textsize = getResources().getDimension(R.dimen.text_size); //dimen에 저장된 글자 크기를 가져와
        setTextSize(textsize); //글자크기 지정
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("MyButton", "onDraw 호출됨");
        //invalidate()가 실행되고 화면이 지워지고 다시 그려질때 호출 여부를 확인하기 위해
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyButton", "onTouchEvent 호출됨");

        int action = event.getAction(); //이벤트를 받아옴

        switch (action){
            case MotionEvent.ACTION_DOWN: //버튼을 눌렀을때
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.RED);
                break;

            case MotionEvent.ACTION_UP: //버튼에서 손을 띈 경우
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.BLACK);
                break;
        }

        invalidate(); //현재 화면을 무효화, onDraw()메서드를 실행하기 위해 실행

        return true;
    }
}
