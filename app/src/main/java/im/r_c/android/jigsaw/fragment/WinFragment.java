package im.r_c.android.jigsaw.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import im.r_c.android.jigsaw.R;

/**
 * Jigsaw
 * Created by richard on 16/5/15.
 */
public class WinFragment extends Fragment {
    public WinFragment() {
    }

    public static WinFragment newInstance(Bitmap bitmap) {
        Bundle args = new Bundle();
        args.putParcelable("image", bitmap);
        WinFragment fragment = new WinFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_win, container, false);
        ImageView iv = view.findViewById(R.id.iv_image);
        iv.setImageBitmap(getArguments().getParcelable("image"));
        return view;
    }
}
