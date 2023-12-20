import Banner from '@/components/Landing/Banner';
import Banner2 from '@/components/Landing/Banner2';
import LandNav from '@/components/Landing/LandNav';
import Navbar from '@/components/Navbar';

export const LandingPage = () => {
	return (
		<div>
			<LandNav />
			<Navbar />
			<Banner />
			<Banner2 />
		</div>
	);
};

export default LandingPage;
