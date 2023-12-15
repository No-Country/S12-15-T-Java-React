/* import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import '@/styles/activity.css';



const ResponsiveCarousel = () => {
  const settings = {
    infinite: true,
    slidesToShow: 4,
    slidesToScroll: 1,
    dots: true,
    responsive: [
      {
        breakpoint: 564,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
        },
      },
    ],
  };

  return (
    <div className="carousel-container">
      <Slider {...settings}>
        <div>
          <img src="/img/Card-Recientes.png" alt="Image 1" />
        </div>
        <div>
          <img src="/img/Card-Recientes2.png" alt="Image 2" />
        </div>
        <div>
          <img src="/img/Card-Recientes3.png" alt="Image 3" />
        </div>
        <div>
          <img src="/img/Card-Recientes4.png" alt="Image 4" />
        </div>
      </Slider>

      <style>{`
        body, html {
          margin: 0;
          padding: 0;
        }

        .carousel-container {
          background-color: white;
          padding: 20px;
          margin: 0 auto;
          max-width: 566px;
          height: auto;
          box-shadow: 0px 4px 4px 4px rgba(0, 0, 0, 0.50);
          border: 2px solid rgba(66, 82, 110, 0.75);
        }

        .slick-prev,
        .slick-next {
          width:600px
          height: 100px;
          background: white;
        }

        .slick-prev:before,
        .slick-next:before {
          color: gray;
          width:600px
          height: 100px;
        }

     

        img {
          width: 100%;
          height: 176px;
        }
      `}</style>
    </div>
  );
};

export default ResponsiveCarousel;
 */

import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

function ResponsiveCarousel() {
	const settings = {
		infinite: true,
		slidesToShow: 4,
		slidesToScroll: 1,
		dots: true,
		responsive: [
			{
				breakpoint: 564,
				settings: {
					slidesToShow: 1,
					slidesToScroll: 1,
					infinite: true,
				},
			},
		],
	};

	return (
		<div className="carousel-container">
			<Slider {...settings}>
				<div>
					<img src="/img/Card-Recientes.png" alt="Image 1" />
				</div>
				<div>
					<img src="/img/Card-Recientes2.png" alt="Image 2" />
				</div>
				<div>
					<img src="/img/Card-Recientes3.png" alt="Image 3" />
				</div>
				<div>
					<img src="/img/Card-Recientes4.png" alt="Image 4" />
				</div>
			</Slider>

			<style>{`
        body, html {
          margin: 0;
          padding: 0;
        }

        .carousel-container {
          background-color: white;
          padding: 20px;
          margin: 0 auto;
          max-width: 566px;
          height: auto;
          box-shadow: 0px 4px 4px 4px rgba(0, 0, 0, 0.50);
          border: 2px solid rgba(66, 82, 110, 0.75);
        }

        img {
          width: 100%;
          height: auto;
        }

        /* Estilos para los botones del carrusel */
        .slick-prev,
        .slick-next {
         ba: gray; /* Cambia el color según tus necesidades */
        }

       

        .slick-prev:before,
        .slick-next:before {
          color: gray;
          width:600px
          height: 100px;
        }


      `}</style>
		</div>
	);
}

export default ResponsiveCarousel;
