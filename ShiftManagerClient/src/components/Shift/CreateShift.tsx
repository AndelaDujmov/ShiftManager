import { useState } from "react";

const Shift = () => {
  const [shift, setShift] = useState({
    type: "",
    shiftStart: "",
    shiftEnd: "",
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    setShift({ ...shift, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log("Shift Data:", shift);
  };

  return (
    <div className="max-w-md mx-auto mt-10 p-6 bg-white rounded-2xl shadow-lg">
      <h2 className="text-xl font-semibold text-gray-700 mb-4">Shift Details</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        {/* Shift Type */}
        <div>
          <label className="block text-gray-600 text-sm font-medium mb-1">Shift Type</label>
          <select
            name="type"
            value={shift.type}
            onChange={handleChange}
            className="w-full p-2 border rounded-lg focus:ring-2 focus:ring-blue-400"
          >
            <option value="">Select Shift Type</option>
            <option value="morning">Morning</option>
            <option value="afternoon">Afternoon</option>
            <option value="night">Night</option>
          </select>
        </div>

        {/* Shift Start */}
        <div>
          <label className="block text-gray-600 text-sm font-medium mb-1">Shift Start</label>
          <input
            type="time"
            name="shiftStart"
            value={shift.shiftStart}
            onChange={handleChange}
            className="w-full p-2 border rounded-lg focus:ring-2 focus:ring-blue-400"
          />
        </div>

        {/* Shift End */}
        <div>
          <label className="block text-gray-600 text-sm font-medium mb-1">Shift End</label>
          <input
            type="time"
            name="shiftEnd"
            value={shift.shiftEnd}
            onChange={handleChange}
            className="w-full p-2 border rounded-lg focus:ring-2 focus:ring-blue-400"
          />
        </div>

        {/* Submit Button */}
        <button
          type="submit"
          className="w-full bg-blue-600 text-white p-2 rounded-lg hover:bg-blue-700 transition"
        >
          Submit Shift
        </button>
      </form>
    </div>
  );
};

export default Shift;
